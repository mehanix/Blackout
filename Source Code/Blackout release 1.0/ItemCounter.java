import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ItemCounter
 * 
 * Clasa care se ocupa cu numaratul duratei efectului obiectului Speedpill,
 * cat si numaratul pietrelor colectate din labrint in Modul Puzzle.
 */
public class ItemCounter extends Actor
{
    public static int[] gems_taken = new int[4]; //vector in care este marcat ce pietre au fost colectate din labirint.
    int ok, s;
    static int pillTimer=300, //Timpul in care Speedpill isi face efectul
               defaultSpeed=2; //viteza normala a jucatorului
               
    static boolean shouldCountdownPill=false; //trigger pentru contorul Speedpillului

    public void act() 
    {
        //verifica daca trebuie scazut timpul.
        checkPillCountdown();
    }  
    
    private void checkPillCountdown()
    {
        //cat timp timerul este > 0, jucatorul are viteza 5
        if(shouldCountdownPill)
        {
            if(pillTimer>0)
                pillTimer--;
            else
                {
                    //cand timerul ajunge la 0, se opreste din scadere si seteaza viteza playerului la viteza normala
                    Player.speed=defaultSpeed;
                    shouldCountdownPill=false;
                    
                }
                
        }        
    }
}
