import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Player - Jucatorul 
 * Una dintre clasele cele mai importante ale jocului.
 * 
 *  Se ocupa cu:
 ** Miscarile jucatorului pe directiile sus, jos, stanga, dreapta
 ** Coliziunile cu peretii labirintului (Wall.class)
 ** Animatiile jucatorului pe cele 4 directii
 */
public class Player extends Actor
{
    static int speed=2; //viteza normala de miscare.
    int frame,
        delay=14;  //odata la cate act cycles sa se schimbe animatia (14 act cycles = 0.4 secunde)
        
    //Imaginile pentru animatiile jucatorului
    GreenfootImage r1 = new GreenfootImage("right1.png");
    GreenfootImage r2 = new GreenfootImage("right2.png");
    GreenfootImage r3 = new GreenfootImage("right3.png");
    GreenfootImage l1 = new GreenfootImage("left1.png");
    GreenfootImage l2 = new GreenfootImage("left2.png");
    GreenfootImage l3 = new GreenfootImage("left3.png");
    GreenfootImage f1 = new GreenfootImage("front1.png");
    GreenfootImage f2 = new GreenfootImage("front2.png");
    GreenfootImage f3 = new GreenfootImage("front3.png");
    GreenfootImage b1 = new GreenfootImage("back1.png");
    GreenfootImage b2 = new GreenfootImage("back2.png");
    GreenfootImage b3 = new GreenfootImage("back3.png");
    
    //trigger care determina daca jucatorul are voie sa se miste.
    //cand este afisat mesajul de castig, el nu se mai poate misca.
    static boolean canMove = true;

    public void act() 
    {
        //Verifica daca jucatorul trebuie mutat.
        checkKeys();
    }    
    void checkKeys()
    {
        if (canMove==true)
        {
            if (Greenfoot.isKeyDown("left"))
                moveLeft();
            if (Greenfoot.isKeyDown("right"))
                moveRight();     
            if (Greenfoot.isKeyDown("up"))
                moveUp();
            if (Greenfoot.isKeyDown("down"))
                moveDown();     
        }
    }
    void moveLeft()
    {
        move(-speed);
        //Daca jucatorul a calcat peste perete, el va fi mutat la pozitia de dinainte.
        if (getOneIntersectingObject(Wall.class) != null) 
            move(speed);
         frame++;
        //Cand frame se afla intr-un anumit interval, schimba imaginea playerului pentru a il anima.
        //Delay-ul are rolul de a incetini viteza schimbarii animatiilor 
        //(o data la 0.4 secunde in loc de la fiecare act cycle)
        if(frame < 1 * delay)
        {
            setImage(l1);
        }
        else if(frame < 2 * delay)
        {
            setImage(l2);
        }
        else if (frame < 3 * delay)
        {
            setImage(l3);
        }
        else {            frame = 1; return;}
    }
        void moveRight()
    {
        move(speed);
        //Daca jucatorul a calcat peste perete, el va fi mutat la pozitia de dinainte.        
        if (getOneIntersectingObject(Wall.class) != null) 
            move(-speed);
                     frame ++;
        //Cand frame se afla intr-un anumit interval, schimba imaginea playerului pentru a il anima.
        //Delay-ul are rolul de a incetini viteza schimbarii animatiilor 
        //(o data la 0.4 secunde in loc de la fiecare act cycle)                     
        if(frame < 1 * delay)
        {
            setImage(r1);
        }
        else if(frame < 2 * delay)
        {
            setImage(r2);
        }
        else if (frame < 3 * delay)
        {
            setImage(r3);

        }
        else {frame = 1; return;}
    }
    void moveUp()
    {
        setLocation(getX(),getY()-speed);
        if (getOneIntersectingObject(Wall.class) != null) 
          setLocation(getX(),getY()+speed);
         frame ++;
        //Cand frame se afla intr-un anumit interval, schimba imaginea playerului pentru a il anima.
        //Delay-ul are rolul de a incetini viteza schimbarii animatiilor
        //(o data la 0.4 secunde in loc de la fiecare act cycle)         
        if(frame < 1 * delay)
        {
            setImage(b1);
        }
        else if(frame < 2 * delay)
        {
            setImage(b2);
        }
        else if (frame < 3 * delay)
        {
            setImage(b3);

        }
        else {frame = 1; return;}        
    }
    void moveDown()
    {
        setLocation(getX(),getY()+speed);
        if (getOneIntersectingObject(Wall.class) != null) 
          setLocation(getX(),getY()-speed); 
         frame ++;
        //Cand frame se afla intr-un anumit interval, schimba imaginea playerului pentru a il anima.
        //Delay-ul are rolul de a incetini viteza schimbarii animatiilor
        //(o data la 0.4 secunde in loc de la fiecare act cycle)         
        if(frame < 1 * delay)
        {
            setImage(f1);
        }
        else if(frame < 2 * delay)
        {
            setImage(f2);
        }
        else if (frame < 3 * delay)
        {
            setImage(f3);

        }
        else {frame = 1; return;}        
    }    

    }

