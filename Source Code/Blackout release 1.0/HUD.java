import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Actor
{
  GemIndicator[] gi = new GemIndicator[5];
    public HUD()
    {
        if (MenuWorld.gamemode==1)
            setImage(new GreenfootImage("hudTA.png"));
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
