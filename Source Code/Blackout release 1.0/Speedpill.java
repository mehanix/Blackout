import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Speedpill
 * 
 * Creeaza un obiect care, atins de jucator, dispare si ii creste viteza de miscare pentru cateva secunde.
 */
public class Speedpill extends Items
{
    static GreenfootSound sound = new GreenfootSound("speedSound.wav"); // create a sound object
    public Speedpill()
    {
            getImage().scale(getImage().getWidth()*2/3,getImage().getHeight()*2/3);       
            sound.setVolume(80);
    }
    
    public void act() 
    {
        //verifica daca jucatorul a atins obiectul.
        checkPlayerCollision();
    }
    
    private void checkPlayerCollision()
    {
       if (getOneIntersectingObject(Player.class) != null)
        {
            //mareste viteza, seteaza cronometrul la 100 (aprox 2 secunde), si elimina obiectul din joc.
            ItemCounter.shouldCountdownPill=true;
            ItemCounter.pillTimer=300;
            Player.speed=4;
            getWorld().removeObject(this);
            if(!MuteButton.mute)            
                sound.play();
        }         
    }
}
