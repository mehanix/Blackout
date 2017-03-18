import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gate - Clasa folosita la generarea labirinturilor in Modul Puzzle
 * 
 * Este poarta care blocheaza iesirea din labirint.
 * Se va deschide cand playerul colecteaza cele 4 nestemate
 */
public class Gate extends Wall
{
    int sum;
    public void act() 
    {
        //Numara cate pietre a colectat jucatorul pana acum
        sum=0;
        for(int i=0;i<4;i++)
            sum+=ItemCounter.gems_taken[i];
        if(sum==4)
            { 
                //adauga teleporter 
                Teleporter tp = new Teleporter();
                getWorld().addObject(tp,this.getX(),this.getY());
                if(Start.lang==0)
                 getWorld().showText("Gate opened!",463,14);
                 else
                 getWorld().showText("Usa deschisa!",463,14);
                //sterge poarta din labirint
                getWorld().removeObject(this);
            }
            
    }    
}
