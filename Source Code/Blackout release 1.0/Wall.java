import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Wall -- Clasa folosita la generarea labirinturilor
 * Cu el se formeaza peretii labirintului.
 * Obiectele care extind aceasta clasa(inclusiv) au proprietatea ca playerul nu poate trece prin ele.
 */

public class Wall extends Actor
{
    GreenfootImage wall2 = new GreenfootImage("wall4.png");
    
    public void act() 
    {
        //Verifica daca mai exista o bucata de perete sub bucata asta
        Actor under = getOneObjectAtOffset(0,getImage().getHeight() / 2,Wall.class);
        if (under == null)
        {
            //schimba textura in textura de margine.
            setImage(wall2);
        }
        
        
    }    
}
