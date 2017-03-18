import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GemIndicator
 * 
 * Iconita a barii de stare care este colorata complet in momentul in care o nestemata a fost colectata de player.
 */
public class GemIndicator extends HUD
{
    int cl;
    public GemIndicator(int colorIndex)
    {
        cl=colorIndex;
  
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
            getImage().scale(getImage().getWidth()*2,getImage().getHeight()*2);            
            getImage().setTransparency(120);
        }
    
    
    public void act() 
    {
        if(ItemCounter.gems_taken[cl]==1)
            getImage().setTransparency(255);
    }    
}
