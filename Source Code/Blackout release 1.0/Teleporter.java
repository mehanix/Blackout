import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Teleporter
 * 
 * Clasa care se ocupa cu:
 *** Trecerea jucatorului la alt nivel(Modul Contra Timp)
 *** Terminarea jocului(Modul Puzzle)
 *
 * Este prezenta la generarea labirintului in ambele moduri de joc.
 */
public class Teleporter extends Actor
{
    public Teleporter()
    {
        //In Modul Contra Timp, teleporterul arata ca o scara pentru a arata trecerea la urmatorul nivel.
        //In Modul Puzzle, arata ca restul podelei(el apare numai dupa ce a fost deschisa poarta(Gate.class))
        if (MenuWorld.gamemode == 1)
            setImage(new GreenfootImage("staircase.png"));
        else
            setImage(new GreenfootImage("bg.png"));
    }
    
    public void act() 
    {
        //cand jucatorul calca pe teleporter
        if(getOneIntersectingObject(Player.class)!=null)
            {
                if(MenuWorld.gamemode == 1)
                    //marcheaza regenerarea labirintului(trecere la nivelul urmator in Modul Contra Timp)
                    TAworld.shouldRegen=true;
                else
                    {   
                      //reseteaza variabilele care tin de modul de joc
                      MenuWorld.gamemode=-1;
                      MenuWorld.isPlaying=false;
                      for(int i=0;i<4;i++)
                            ItemCounter.gems_taken[i]=0;
    
                      //arata fereastra de castig      
                      PMworld.shouldShowVictoryWindow=true;
                    }
     
            }
            
    }    
}
