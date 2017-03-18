import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * TimeIndicator
 * 
 * Text afisat pe bara de stare care arata locul unde se afla timpul/timpul ramas.
 */
public class TimeIndicator extends HUD

{

    public TimeIndicator() 
    {
    
        if (MenuWorld.gamemode==1)
            {
                if (Start.lang==0)
                    {
                        GreenfootImage logo = new GreenfootImage("EnTimeRemainingText.png");
                        setImage(logo);
                    }
                else
                    {
                        GreenfootImage logo = new GreenfootImage("RoTimeRemainingText.png");
                        setImage(logo);                        
                    }
            }
            else
            {
            
                if (Start.lang==0)
                    {
                        GreenfootImage logo = new GreenfootImage("EnTimeText.png");
                        setImage(logo);
                    }
                else
                    {
                        GreenfootImage logo = new GreenfootImage("RoTimeText.png");
                        setImage(logo);                        
                    }
            
            
            }
    }    
}
