import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Eyeglasses
 * 
 * Obiect care poate fi prezent in labirint. Cand este atins, el mareste raza FOV-ului din jurul jucatorului.
 */
public class Eyeglasses extends Items
{
    static GreenfootSound sound = new GreenfootSound("powerupSound.wav"); // create a sound object
    public Eyeglasses()
    {
         sound.setVolume(80);
    }
    public void act() 
    {
       if (getOneIntersectingObject(Player.class) != null)
        {
            //marcheaza ca trebuie marit FOV-ul
            FOV.SwitchImage=true;
            getWorld().removeObject(this);
         if(!MuteButton.mute)
            sound.play();
        } 
    }    
}
