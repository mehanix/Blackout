import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tutorial
 * 
 * Clasa care afiseaza imaginile care formeaza tutorialul jocului.
 * In aceste imagini se explica ce face fiecare element al jocului.
 * In functie de limba aleasa, tutorialul va avea imagini diferite.
 */
public class Tutorial extends Start
{
    int clickCounter=0;
    public Tutorial()
    {
        //seteaza imaginea in functie de limba
       if (Start.lang==0)
       {
           GreenfootImage tut1 = new GreenfootImage("EnTutPic1.png");
           setImage(tut1);
       }
       else
       {
           GreenfootImage tut1 = new GreenfootImage("RoTutPic1.png");
           setImage(tut1);                        
       }
   
    }
    
    public void act()
    {
        getWorld().showText(" ", 473,640);
        if (Greenfoot.mouseClicked(this))
            {
                clickCounter++;
                if (clickCounter == 1)
                    //afiseaza a doua parte a tutorialului
                    if (Start.lang == 0)
                        setImage(new GreenfootImage("EnTutPic2.png"));
                    else
                        setImage(new GreenfootImage("RoTutPic2.png"));
                else
                   {
                     //reseteaza variabilele butoanelor si elimina tutorialul din lume
                     MenuWorld.gamemode=-1;
                     MenuWorld.tutorialShown=false;                     
                      clickCounter=0;
                      getWorld().removeObject(this);
                   }
            }
    }    
}
