import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)    
import java.util.List;
import java.io.IOException;
/**
 * Lumea modului Contra Timp
 * 
 * Se genereaza un labirint. Cand playerul gaseste iesirea, acesta este sters si inlocuit de un labirint mai mare.
 * Afisarea labirinturilor se face in mod diferit fata de Modul Puzzle, fiind nevoie sa se centreze labirintul pe ecran,
 * se calculeaza un offsetX si offsetY in functiie de dimensiunile lui si se centreaza toate obiectele folosindu-se de acesta.
 */ 
public class TAworld extends World
{

    public final int pixelSize=32; //dimensiunea unei bucati de zid in pixeli
    int[][] b;
    int offsetX,
        offsetY,
        width=getWidth(),
        height=getHeight(),
        chance;
    public int rw=4, //dimensiunile initiale ale labirintului
               cl=2;
    ItemCounter it;
    public static int remainingTime=7800; //in act cycles. 65 act cycles = aprox 1 secunda
    public static boolean shouldRegen=false;
    public static boolean victoryWindowShown=false,
                  shouldSwitchWorld=false;
    public int level=1; //contor al nivelelor parcurse
    MenuWorld ww; //lumea meniului(pentru trecerea inapoi la meniu)
    
    public TAworld(MenuWorld w)
    {    
       super(928, 672, 1,false); 
       setBackground("BlackBg.png");
       generateMap(rw,cl);
       setPaintOrder(HUD.class,FOV.class); 
       createHUD();
       ww=w;
    }
    public void act()
    {
        checkIfMazeRegen();
        checkVictory();
        checkForWorldSwitch();    
        showTime();
        showLevel();
    }    
    void generateMap(int row, int col)
    {
        GreenfootImage zid = new GreenfootImage("wall5.png");
        Generator gen = new Generator(row,col);
        gen.makeMaze();
        b=gen.getMaze();
        int[] xy = new int[2];
        xy=gen.getRandomEmptyPosition();        
        //calcularea offsetului labirintului curent
        offsetX=(width-(gen.getRows())*pixelSize)/2;    
        offsetY=(height-(gen.getCols()+2)*pixelSize)/2;    
        
        //adauga iesirea
        //iesirea va fi pusa la o distanta cat mai mare de locul unde a fost generat playerul
       int entrance_row = Greenfoot.getRandomNumber(row-1) * 2 +1;     
        if(!(xy[1]<=col+1))
             {
                 b[entrance_row][0] = 4;

                }
                    else
             {
                 b[entrance_row][gen.getCols()-1] = 4;

            } 
        
        //afisarea labirintului in lume 
        for(int i=0;i<=gen.getRows()-1;i++)
            for(int j=0;j<=gen.getCols()-1;j++)
            {
                if(b[i][j]==1)
                {
                    Wall wall = new Wall();
                    addObject(wall,i*pixelSize+pixelSize/2+offsetX,j*pixelSize+pixelSize/2+offsetY);
                }
                else
                {
                    Floor floor = new Floor();
                    addObject(floor,i*pixelSize+pixelSize/2+offsetX,j*pixelSize+pixelSize/2+offsetY);                    
                }
            }
            
        //adaugarea obiectului care face trecerea la labirintul urmator
        if (b[entrance_row][0]==4)
        {
            Teleporter tp = new Teleporter();     
            addObject(tp,entrance_row*pixelSize+pixelSize/2+offsetX,0*pixelSize+pixelSize/2+offsetY);                    
        }
        else
        {
            Teleporter tp = new Teleporter();                 
            addObject(tp,entrance_row*pixelSize+pixelSize/2+offsetX,(gen.getCols()-1)*pixelSize+pixelSize/2+offsetY);                    
        }
          
        addObjects(gen);
        addPlayer(gen);
    }
    private void createHUD()
    {
       //adaugarea barii de stare in lume
       ItemCounter it = new ItemCounter();
       addObject(it,0,0);
       //adauga bara de stare
       HUD hud = new HUD();
       addObject(hud,474,641);
       //adauga indicator mod de joc
       GamemodeIndicator gma = new GamemodeIndicator();
       addObject(gma,279,639);
       //adauga indicator bomboana
       SpeedpillIndicator spi = new SpeedpillIndicator();
       addObject(spi,460,640);
       //adauga indicator ochelari
       EyeglassesIndicator egi = new EyeglassesIndicator();
       addObject(egi,498,643);
       //adauga indicator timo
       TimeIndicator tmi = new TimeIndicator();
       addObject(tmi,583,638);
       //adauga indicator nivel curent
       LevelIndicator le = new LevelIndicator();
       addObject(le,383,640);
       //adauga buton mute/unmute
       MuteButton mutebutton = new MuteButton();
       addObject(mutebutton,20,20);
      //adauga buton mers inapoi la meniu
       MainMenuButton menubutton = new MainMenuButton();
       addObject(menubutton,56,22);       
    }

    private void checkIfMazeRegen()
    {
        //metoda care verifica daca trebuie regenerat labirintul
        if(shouldRegen==true)
        {
            //trece la nivelul urmator si mareste dimensiunile labirintului
            //pana ajunge la dimensiunea maxima
            level++;
            if(rw<14)
            rw+=2;
            if(cl<9)
            cl+=1;
            removeOldMaze();
            generateMap(rw,cl);
            shouldRegen=false;
        }    
    }
    private void removeOldMaze()
    {
        //metoda care elimina toate obiectele din lume inafara de bara de stare si contorul itemelor
        List objects = getObjects(null);
        objects.removeAll(getObjects(ItemCounter.class));
        objects.removeAll(getObjects(HUD.class)); 
        removeObjects(objects);        
    }
    private void checkVictory()
    {
        //metoda care verifica daca este indeplinita conditia de victorie
        if (remainingTime>=0)
            remainingTime--;
        else if (victoryWindowShown == false)
        {
            VictoryWindow vw = new VictoryWindow();
            Player.canMove=false;
            addObject(vw,566,337);
            victoryWindowShown=true;
            //afisare text caseta victorie
            if (Start.lang==0)
                {
                    showText("Congratulations!",478,305);
                    showText("You have completed Time Attack!",478,325);
                    showText("The level you reached is: " + level, 478, 345);
                    try
                    {
                        if (isBestLevel())
                            {
                                showText("New record!",478,365);
                            }
                    }
                    catch (IOException ex)
                    {
                       showText("Error reading score file!",478,305);
                    }
                    



                }
            else
                {
                    showText("Felicitari!",478,305);
                    showText("Ai terminat Modul Contra Timp!",478,325);
                    showText("Nivelul la care ai ajuns este: " + level,478,345);
                    try
                    {
                        if (isBestLevel())
                            {
                                showText("Nou record!",478,365);
                            }
                    }
                    catch (IOException ex)
                    {
                       showText("Eroare la citirea din fisier",478,305);    
                    }
                }            
        }       
    }
    private void checkForWorldSwitch()
    {
        //verifica daca trebuie trecut inapoi la meniul prinicipal
        if(shouldSwitchWorld==true)
        {
            StaticVariableResetter.resetTAVariables();
            Greenfoot.setWorld(ww);
        }
    }
    private void showTime()
    {
        //afiseaza timpul ramas (65 act cycles = 1 secunda aprox)
        showText(String.valueOf(remainingTime/65), 672, 640);
    }
    private void showLevel()
    {
        //afiseaza nivel curent
        showText(String.valueOf(level), 401, 639);    
    }
    boolean isBestLevel() throws IOException
    {
        //functie care determina daca nivelul ajuns acum este mai bun decat nivelul salvat in fisierul de scor
        String line;
        ReadFile file = new ReadFile("TAscore.txt");
        line = file.OpenFile();     
        if (Integer.valueOf(line) < level)
            {
                //write to file
                WriteFile data = new WriteFile("TAscore.txt");
                data.writeToFile(String.valueOf(level));

                return true;
            }
        return false;
    }
    private void addObjects(Generator gen)
    {
        //adauga obiectele in labirint
        int[] xy = new int[2];
        Speedpill sp = new Speedpill();
        xy=gen.getRandomEmptyPosition();
        addObject(sp, xy[0]*pixelSize+pixelSize/2+offsetX, xy[1]*pixelSize+pixelSize/2+offsetY);
    
        //ochelarii au sansa de a se instantia doar de 15%pe lume
        chance=Greenfoot.getRandomNumber(101);
        if(chance<=15 && FOV.SwitchImage == false)
        {
            Eyeglasses eg = new Eyeglasses();
            xy=gen.getRandomEmptyPosition();
            addObject(eg, xy[0]*pixelSize+pixelSize/2+offsetX, xy[1]*pixelSize+pixelSize/2+offsetY);        
                }        
    }
    private void addPlayer(Generator gen)
    {
        //adauga playerul
        int[] xy = new int[2];        
        xy=gen.getRandomEmptyPosition(); 
        Player p = new Player();
        addObject(p , xy[0]*pixelSize+pixelSize/2+offsetX , xy[1]*pixelSize+pixelSize/2+offsetY);    
       FOV fov = new FOV(p);
       addObject(fov,p.getX(),p.getY());          
    }
}
