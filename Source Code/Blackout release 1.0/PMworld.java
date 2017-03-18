import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;

/**
 * PMworld 
 * 
 * Lumea modului Puzzle. 
 * 
 * Se genereaza un labirint de 28/18, apoi se aseaza cele 4 nestemate in pozitii aleatorii diferite
 * Usa va fi inchisa pana la colectarea celor 4 nestemate.
 */
public class PMworld extends World
{
    public final int pixelSize=32; //lungimea/latimea unei bucati de zid in pixeli
    Generator gen;
    int[][] b; //matricea in care se genereaza labirintul
    Gate gat;
    GemIndicator[] gi= new GemIndicator[4];
    public int ElapsedTime=0;
    //triggere pentru stari din joc
    static boolean shouldShowVictoryWindow=false,
                   VictoryWindowShown=false,
                   shouldSwitchWorld=false;
    //lumea meniului
    MenuWorld ww;
    int[] xy = new int[2];
  //  Generator gen;
    public PMworld(MenuWorld w)
   
    {   
        super(928, 672, 1); 
        setBackground("BlackBg.png");
        setPaintOrder(HUD.class,FOV.class,Gate.class,Player.class,Items.class,Floor.class); 
        generateMap(14,9);    
        ww=w;
    }
    void generateMap(int row, int col)
    {
        GreenfootImage zid = new GreenfootImage("wall5.png");
        generateMaze(row,col);       
    }
    public void act()
    {
        checkTimer();
        checkVictory();

    }
    private void generateMaze(int row, int col)
    {  
        //generare labirint 
       Generator gen = new Generator(row,col);
       gen.makeMaze();
       b=gen.getMaze();
       drawMaze(gen,row,col);
       placeObjects(gen);       
       createHUD();      
    }    
   
    private void placeObjects(Generator gen)
    {
        //adauga nestemate
        for(int i=0;i<4;i++)
        {
            xy=gen.getRandomEmptyPosition();
            Gem g = new Gem(i);
            addObject(g,xy[0]*pixelSize+pixelSize/2,xy[1]*pixelSize+pixelSize/2);
        }
        
        
        //adauga buff viteza
        Speedpill sp = new Speedpill();
         xy=gen.getRandomEmptyPosition();
        addObject(sp,xy[0]*pixelSize+pixelSize/2,xy[1]*pixelSize+pixelSize/2);
        
        
        //adauga buff eyesight
         Eyeglasses eg = new Eyeglasses();
         xy=gen.getRandomEmptyPosition();
        addObject(eg,xy[0]*pixelSize+pixelSize/2,xy[1]*pixelSize+pixelSize/2);

        //adauga obiect contor timp pt bomboana
       ItemCounter it = new ItemCounter();
       addObject(it,0,0); 
       ItemCounter.shouldCountdownPill=false;        
    }
    
    private void createHUD()
    {
       //adauga hud
       HUD h=new HUD();
       addObject(h,535,638);
       for(int i=0;i<4;i++)
           {
              gi[i]=new GemIndicator(i);
              addObject(gi[i],312 + i*(gi[i].getImage().getWidth() + 5),638);
           }       
       //adauga indicator mod de joc curent
       GamemodeIndicator gma = new GamemodeIndicator();
       addObject(gma,229,638);
       //adauga label timp
       TimeIndicator tmi = new TimeIndicator();
       addObject(tmi,624,641);
       //adauga indicator bomboana
       SpeedpillIndicator spi = new SpeedpillIndicator();
       addObject(spi,489,640);
       //adauga indicator ochelari
       EyeglassesIndicator egi = new EyeglassesIndicator();
       addObject(egi,530,641);  
       //adauga buton mute/unmute
       MuteButton mutebutton = new MuteButton();
       addObject(mutebutton,20,20);
       //adauga buton mers inapoi la meniu
       MainMenuButton menubutton = new MainMenuButton();
       addObject(menubutton,56,22);
    }
    private void checkTimer()
    {
        //adauga timp la contor atat timp cat playerul nu a castigat jocul
        if (Player.canMove == true)
            ElapsedTime++;
        //afisarea timpului (65 act cycles = aprox 1 secunda)
            showText(String.valueOf(ElapsedTime/65),710,640);        
    }

    private void drawMaze(Generator gen,int row, int col)
    {
        //deseneaza in lume labirintul generat in matrice
        int exit_row = Greenfoot.getRandomNumber(row-1) * 2 +1;
        
        //adauga player
        xy=gen.getRandomEmptyPosition();        
        Player p = new Player();
        addObject(p,xy[0]*pixelSize+pixelSize/2,xy[1]*pixelSize+pixelSize/2);
        Player.speed=2;
        FOV fov = new FOV(p);
        addObject(fov,p.getX(),p.getY());        
      
      //adauga poarta
      //poarta va fi pusa la o distanta cat mai mare de locul unde a fost generat playerul
        if(!(xy[1]<=col+1))
             {
                 b[exit_row][0] = 4;
                 Gate gat = new Gate();

                 addObject(gat,exit_row*pixelSize+pixelSize/2,0*pixelSize+pixelSize/2);
                }
                    else
             {
                 b[exit_row][gen.getCols()-1] = 0;
                 Gate gat = new Gate();

                 addObject(gat,exit_row*pixelSize+pixelSize/2,(gen.getCols()-1)*pixelSize+pixelSize/2);
            }
            
            //deseneaza labirint
        for(int i=0;i<=gen.getRows()-1;i++)
            for(int j=0;j<=gen.getCols()-1;j++)
            {
                if(b[i][j]==1)
                {
                    Wall wall = new Wall();
                    addObject(wall,i*pixelSize+pixelSize/2,j*pixelSize+pixelSize/2);
                }
                else
                {
                    Floor floor = new Floor();
                    addObject(floor,i*pixelSize+pixelSize/2,j*pixelSize+pixelSize/2);                    
                }                
            }        
    }
    private void checkVictory()
    {
        //metoda care verifica daca s-au indeplinit conditiile de castig
        if(shouldShowVictoryWindow == true && VictoryWindowShown==false)
        {
            VictoryWindow vw = new VictoryWindow();
            Player.canMove=false;
            addObject(vw, 566, 337);
            VictoryWindowShown=true;
            if (Start.lang==0)
                {
                    showText("Congratulations!",478,305);
                    showText("You have completed Puzzle Mode!",478,325);
                    showText("Your time is: " + ElapsedTime/65+"s",478,345);
                    try
                    {
                        if (isBestTime())
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
                    showText("Ai terminat Modul Puzzle!",478,325);
                    showText("Timpul tau este: "+ElapsedTime/65+"s",478,345);
                    try
                    {
                        if (isBestTime())
                            {
                                showText("Nou record!",478,365);
                            }
                    }
                    catch (IOException ex) 
                    {
                         showText("Eroare la citirea fisierului de scor",478,305);                           
                    }
                }            
        }
         if(shouldSwitchWorld==true)
        {
            StaticVariableResetter.resetPMVariables();
            Greenfoot.setWorld(ww);
            
        }       
    }
    boolean isBestTime() throws IOException
    {
        //metoda care verifica daca timpul obtinut 
        //de jucator este mai bun decat ultimul timp salvat
        String line;
        //deschiderea file readerului
        ReadFile file = new ReadFile("PMscore.txt");
        line = file.OpenFile();     
        if (Integer.valueOf(line) > ElapsedTime/65)
            {
                //scrie in fisier scorul nou daca este mai bun 
                WriteFile data = new WriteFile("PMscore.txt");
                data.writeToFile(String.valueOf(ElapsedTime/65));

                return true;
            }
        return false;
    }
        
}
