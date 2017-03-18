import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LevelIndicator
 * 
 * Parte a barii de stare care afiseaza locul unde se afla inscriptionat numarul nivelului curent.
 */
public class LevelIndicator extends HUD
{

    public LevelIndicator()
    {
        if (MenuWorld.gamemode==1)
            {
                if (Start.lang==0)
                    {
                        GreenfootImage logo = new GreenfootImage("EnLevel.png");
                        setImage(logo);
                    }
                else
                    {
                        GreenfootImage logo = new GreenfootImage("RoLevel.png");
                        setImage(logo);                        
                    }
            }          
    }  
}
