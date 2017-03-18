import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * FOV (Field Of View)
 * 
 * Clasa care fixeaza in jurul jucatorului un cerc transparent, pentru a vedea in jurul lui numai pe o anumita raza.
 * 
 */
public class FOV extends Actor
{
    /**
     * Act - do whatever the FOV wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     int width= 928,
         height=672;   
     
     World world = getWorld();
     GreenfootImage bkg;
     GreenfootImage bkg_bigger;
     public Player pp;
     
     public static boolean SwitchImage = false;
     public boolean SwitchTrigger = false;
     
    public FOV(Player p)
    {
        //seteaza imaginile Field Of View-ului
        bkg = new GreenfootImage("fov.png");
        bkg_bigger = new GreenfootImage("fov_bigger.png");
        pp=p;
        setImage(bkg);        
    }
    public void act() 
    {

        //cand cineva colecteaza ochelarii si imaginea n-a fost schimbata in cea cu raza cercului mai mare
        if(SwitchImage==true && SwitchTrigger==false)
            {
                //schimba imaginea
                SwitchTrigger=true;
                setImage(bkg_bigger);

            }
       //seteaza locatia FOV-ului unde este playerul.
       setLocation(pp.getX(), pp.getY());

    }    
}
