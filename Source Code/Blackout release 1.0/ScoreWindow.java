import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ScoreWindow
 * 
 * Creeaza fereastra pe care se vor afisa scorurile cele mai bune obtinute de jucator.
 * 
 */
public class ScoreWindow extends Start
{
    
    public ScoreWindow()
    {
        //in functie de limba aleasa, seteaza imaginea ferestrei.
        if (Start.lang==0)
            {
                GreenfootImage tut1 = new GreenfootImage("EnScoreWindow.png");
                setImage(tut1);
            }
        else
            {
                GreenfootImage tut1 = new GreenfootImage("RoScoreWindow.png");
                setImage(tut1);                        
            }
    }  
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
            {
                //elimina fereastra din joc si reseteaza variabilele butonului
                MenuWorld.gamemode=-1;
                MenuWorld.scoreWindowShown=false;
                MenuWorld.shouldResetText=true;
                getWorld().removeObject(this);
            }        
    }
}
