import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MenuButton
 * 
 * Buton care apare in ambele moduri de joc
 * Care face intoarcerea la meniu
 */
public class MainMenuButton extends HUD
{

    public MainMenuButton()
    {
        if (Start.lang==0)
            setImage(new GreenfootImage("EnReturnMenuBtn.png"));
            else
            setImage(new GreenfootImage("RoReturnMenuBtn.png"));
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
            if (MenuWorld.gamemode==1)
                TAworld.shouldSwitchWorld=true;
            else
                PMworld.shouldSwitchWorld=true;
    }    
}
