import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * MuteButton
 * 
 * Buton care opreste/porneste muzica de fundal.
 */
public class MuteButton extends HUD
{
    GreenfootImage muted = new GreenfootImage("muted.png");
    GreenfootImage unmuted = new GreenfootImage("unmuted.png");
    static boolean mute=false;
    public MuteButton()
    {
        if (MenuWorld.backgroundMusic.isPlaying()==true)
            setImage(unmuted);
        else
            setImage(muted);
    }
    
    public void act() 
    {
        //in functie de starea curenta a muzicii, seteaza butonul
       if (MenuWorld.backgroundMusic.isPlaying()==true)
            setImage(unmuted);
       else
            setImage(muted);        
      if (Greenfoot.mouseClicked(this))
        {
            //opreste sau porneste toate sunetele din joc
            if (MenuWorld.backgroundMusic.isPlaying() ==true)
            {
                MenuWorld.backgroundMusic.pause();
                mute=true;
            }
            else
            {
            MenuWorld.backgroundMusic.play();
            mute=false;
            }
        
        }
        
    }    
}
