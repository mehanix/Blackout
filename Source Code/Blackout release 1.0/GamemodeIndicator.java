import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GamemodeIndicator
 * 
 * Parte a barii de stare care arata modul de joc curent.
 */
public class GamemodeIndicator extends HUD
{

    public GamemodeIndicator() 
    {
        if (MenuWorld.gamemode==1)
            {
                if (Start.lang==0)
                    {
                        GreenfootImage logo = new GreenfootImage("EnHudTextTA.png");
                        setImage(logo);
                    }
                else
                    {
                        GreenfootImage logo = new GreenfootImage("RoHudTextTA.png");
                        setImage(logo);                        
                    }
            }
            else
            {
            
                if (Start.lang==0)
                    {
                        GreenfootImage logo = new GreenfootImage("EnHudTextPM.png");
                        setImage(logo);
                    }
                else
                    {
                        GreenfootImage logo = new GreenfootImage("RoHudTextPM.png");
                        setImage(logo);                        
                    }
            
            
            }
            
        
        
    }    
}
