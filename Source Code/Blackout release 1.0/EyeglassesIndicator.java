import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EyeglassesIndicator
 * 
 * Indicator al barii de stare care arata daca ochelarii au fost luati.
 */
public class EyeglassesIndicator extends HUD
{
    public EyeglassesIndicator()
    {
        setImage(new GreenfootImage("eyeglasses.png"));            
        getImage().scale(getImage().getWidth()*3/2,getImage().getHeight()*3/2);        
        getImage().setTransparency(120);        
    }    
    
    public void act() 
    {
        //cand este luat obiectul, va fi marcat aici.
        if (FOV.SwitchImage == true)
            {
                getImage().setTransparency(255);
            }
    }    
}
