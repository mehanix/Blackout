import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gem
 * 
 * Clasa care creeaza un obiect Gem, cu culoarea specificata de colorIndex.
 * La atingerea de catre jucator al obiectului, el dispare si seteaza in vectorul gems_taken
 * pe pozitia colorIndex valoarea 1, ceea ce inseamna ca piatra a fost colectata.
 */

public class  Gem extends Items
{
    public int cl;

    static GreenfootSound sound = new GreenfootSound("gemPickup.wav"); // create a sound object
    public Gem(int colorIndex)
    {
        cl=colorIndex;
         sound.setVolume(80);
        //seteaza imaginea obiectului in functie de culoarea specificata in apelarea constructorului.
        switch(colorIndex)
        {
            case 0:
                {
                    GreenfootImage color = new GreenfootImage("gemRed.png");
                    setImage(color);
                    break;
                }
            case 1:
                {
                    GreenfootImage color = new GreenfootImage("gemBlue.png");
                    setImage(color);
                    break;
                }                
        
            case 2:
                {
                    GreenfootImage color = new GreenfootImage("gemGreen.png");
                    setImage(color);
                    break;
                }
            case 3:
                {
                    GreenfootImage color = new GreenfootImage("gemYellow.png");
                    setImage(color);
                    break;
                }                
            
            }
       getImage().scale(getImage().getWidth()*3/2,getImage().getHeight()*3/2);            
        }
    
    public void act() 
    {
        //la atingerea jucatorului, dispare si seteaza in vectorul gems_taken faptul ca a fost luata
        if (getOneIntersectingObject(Player.class) != null)
        {
            ItemCounter.gems_taken[cl]=1;
            getWorld().removeObject(this);
            if(!MuteButton.mute)            
                sound.play();
        }        
    }    
}
