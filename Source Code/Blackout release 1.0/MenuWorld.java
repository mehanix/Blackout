import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
/**
 * MenuWorld
 * 
 * Lumea initiala a jocului, care contine meniul care duce la celelalte moduri de joc.
 */
public class MenuWorld extends World
{


    Player p;
    public static int gamemode=-1;
    public static boolean isPlaying=false,tutorialShown=false,scoreWindowShown=false,shouldResetText=false;
    public int psize=32;
    Generator gen;
    int[][] b;
       static GreenfootSound backgroundMusic = new GreenfootSound("bgmusic.wav");
    static Button[] bt = new Button[5];
    public MenuWorld()
    {    

        super(928, 672, 1, false);
        backgroundMusic.setVolume(60);
        backgroundMusic.playLoop();
        
        resetStaticVariables();
        Start s = new Start();
        //adaugarea selectorilor de limbba
        if(Start.lang == (-1))
        {
            roLangSelector ro = new roLangSelector();
            enLangSelector en = new enLangSelector();
            addObject(ro,getWidth()/2-80,getHeight()/2); 
            addObject(en,getWidth()/2+80,getHeight()/2);
        }
        addObject(s,getWidth()/2,getHeight()/2);  
        MuteButton mutebutton = new MuteButton();
        addObject(mutebutton,20,20);
    }
    public void act()
    {
        if(Start.lang!=-1&& Start.hasBeenAnimated==false)
        {
           addMenu();
           Start.hasBeenAnimated=true;
        }
        checkGamemode(); 
    }
    void addMenu()
    {
        MenuLogo ml = new MenuLogo();
        addObject(ml,473,115);
        for(int i=0;i<4;i++)
            {
            //   if (i%160 
               bt[i] = new Button(i,Start.lang);
               
               addObject(bt[i],473,600+100*i);

            }
    }
    int getTAScore() throws IOException 
    {
        //ia valoarea scorului pentru Modul Contra Timp
        String line;
        ReadFile file = new ReadFile("TAscore.txt");
        line = file.OpenFile();
        //daca valoarea din fisier este valoarea default 0, inseamna ca 
        //nu a fost jucat niciodata acest mod de joc si nu trebuie afisat
        //altfel, returneaza scorul obtinut
        if(Integer.valueOf(line) == 0)
            return -1;
        return Integer.valueOf(line);
    }
    int getPMScore() throws IOException
    {
        //ia valoarea scorului pentru modul Puzzle
        String line;
        ReadFile file = new ReadFile("PMscore.txt");
        line = file.OpenFile();
        if(Integer.valueOf(line) == 999999)
            return -1;
        return Integer.valueOf(line);
    }    
    private void checkGamemode()
    {
        //functia care se ocupa de trecerea din meniu in modurile diferite de joc sau in tutorial/pagina de scoruri
        switch (gamemode)
        {
            //modul contra timp
            case 1:
            {
                if (isPlaying == false)
                {
                    isPlaying=true;
                    TAworld w = new TAworld(this);
                    Greenfoot.setWorld(w);                    
                }
                break;
            }
            //modul puzzle
            case 2:
            {
                if (isPlaying == false)
                {
                    isPlaying=true;
                    PMworld ww = new PMworld(this);
                    Greenfoot.setWorld(ww);
                }
                break;
            }
            //afisarea tutorialului
            case 3:
            {
                if (tutorialShown==false)
                {
                    Tutorial tut = new Tutorial();
                    addObject(tut,getWidth()/2,getHeight()/2);
                    tutorialShown=true;
                }
                break;
            }
            //afisarea paginii de scoruri
            case 4:
            {
                if (scoreWindowShown==false)
                {
                    ScoreWindow sw = new ScoreWindow();
                    addObject(sw,546,359);
                    try
                    {
                        int TAscore = getTAScore();
                        int PMscore = getPMScore();
                        
                            //in functie de limba, afiseaza scorurile
                            if (Start.lang==0)
                            {
                                if(PMscore!=-1)
                                showText("Best Puzzle Mode time: "+ PMscore +"s",getWidth()/2,getHeight()/2-50);
                                else
                                showText("You have never played Puzzle Mode",getWidth()/2,getHeight()/2-50);
                                if (TAscore!=-1)
                                showText("Highest Time Attack level reached: " + TAscore,getWidth()/2,getHeight()/2);
                                else
                                showText("You have never played Time Attack Mode",getWidth()/2,getHeight()/2);
                            }
                            else
                            {
                                if(PMscore!=-1)
                                    showText("Cel mai bun timp in Modul Puzzle: "+ PMscore +"s",getWidth()/2,getHeight()/2-50);
                                else
                                    showText("Nu ai jucat niciodata Modul Puzzle",getWidth()/2,getHeight()/2-50);
                                if (TAscore!=-1)
                                    showText("Nivelul maxim atins in Modul Contra Timp: " + TAscore,getWidth()/2,getHeight()/2);
                                else
                                    showText("Nu ai jucat niciodata Modul Contra Timp",getWidth()/2,getHeight()/2);                            
                            }
                       

                        
                        scoreWindowShown=true;
                    } catch (IOException ex) 
                    {
                        showText("A aparut o eroare la citirea scorurilor din fisiere",getWidth()/2,getHeight()/2-50);
                    }
                }
            }
        }
        //stergerea textului la inchiderea ferestrei de scor
        if (shouldResetText==true)
        {
            showText(" ",getWidth()/2,getHeight()/2-50);   
            showText(" ",getWidth()/2,getHeight()/2);
            shouldResetText=false;
        }         
    }
    private void resetStaticVariables()
    {       
        //resetarea variabilelor statice folosite in proiect
        StaticVariableResetter.resetMenuVariables();
        StaticVariableResetter.resetTAVariables();
        StaticVariableResetter.resetPMVariables();
    }
}


