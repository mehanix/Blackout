import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * EyeglassesIndicator
 * 
 * Indicator al barii de stare care este activat cat timp bomboana isi face efectul.
 */
public class SpeedpillIndicator extends HUD
{
    //la crearea barii de stare indicatorul e semitransparent
    public SpeedpillIndicator()
    {
            setImage(new GreenfootImage("speedpill.png"));

            getImage().setTransparency(120);        
    }
    public void act() 
    {
        //cat timp isi face efectul, sa fie colorat complet
        if (ItemCounter.shouldCountdownPill == true)
            {
                getImage().setTransparency(255);
            }
            else
            {
                getImage().setTransparency(120);    
            }
    }    
}
