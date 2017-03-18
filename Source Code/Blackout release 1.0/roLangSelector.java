import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * roLangSelector
 * 
 * Clasa care creeaza un buton ce, odata apasat, seteaza limba jocului la romana.
 */
public class roLangSelector extends Language
{

    public roLangSelector()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() -270, image.getHeight() - 270);
        setImage(image);
    }
    public void act() 
    {
       if (Greenfoot.mouseClicked(this))
           lang=1;
       //cand a fost setata limba de unul dintre butoane, elimina butonul din joc.                
       if(lang!=-1)
            getWorld().removeObject(this);
    }    
}
