import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start
 * 
 * Afiseaza imaginea de inceput (cu logoul Blackout!) si dispare prin fade-out dupa cateva secunde.
 * Contine variabila statica lang, care seteaza limba jocului.
 *
 */
public class Start extends Actor
{
    public static int lang=-1;  //Lang este: 0 pentru engleza, 1 pentru romana, -1 pentru nesetata.
    int transparencyLevel=100;  //nivelul de transparenta al pozei de inceput 
    int timer=50, //timpul cat sta imaginea pe ecran (aprox. 1 sec)
        i;
        
    static boolean hasBeenAnimated=false;
    boolean Faded=false;

    World world = getWorld();
    GreenfootImage gf = new GreenfootImage(1,1);
    public void act() 
    {
        //animeaza disparitia imaginii.
        animate();
    }
    private void animate()
    {
        //scade din timer
       if (timer>0)
            timer--;
            
       if(timer==0 && !Faded)
        {
            Faded=true;
            //creste gradat transparenta imaginii
            for(i=1;i<=25;i++)
               {
                   transparencyLevel-=4;
                   getImage().setTransparency(transparencyLevel);
                   Greenfoot.delay(1);
               }
               
       }
       //elimina imaginea din lume cand a fost aleasa limba si a ajuns la transparenta 100%
         if(i==26)
         {
             setImage(gf);
             if(lang!=-1)
                getWorld().removeObject(this);
         }        
    }
    }

