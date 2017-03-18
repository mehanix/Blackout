import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * enLangSelector
 * 
 * Clasa care creeaza un buton ce, odata apasat, seteaza limba jocului la engleza.
 */
public class enLangSelector extends Language
{
    public enLangSelector()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() -270, image.getHeight() - 270);
        setImage(image);
    }
    public void act() 
    {
       if (Greenfoot.mouseClicked(this))
            lang=0;
       //cand a fost setata limba de unul dintre butoane, elimina butonul din joc.     
       if(lang!=-1)
            getWorld().removeObject(this);
            
    }    
}
