import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;
/**
 *  Button
 *  
 *  Clasa care creeaza un buton. Butonului i se imprima un string in functie de functia lui(campul type din constructor)
 *  si de limba aleasa de utilizator.
 *  
 *  La apasarea butonului, el seteaza modul de joc(gamemode) la tipul lui.
 */
public class Button extends Start
{
    static GreenfootSound sound = new GreenfootSound("buttonClick.wav");
    GreenfootImage btn = new GreenfootImage("btn.png");
    GreenfootImage btn_pressed = new GreenfootImage("btn_pressed.png");
    GreenfootImage btn_hovered = new GreenfootImage("btn_hovered.png");
    GreenfootImage btn1 = new GreenfootImage("btn.png");
    GreenfootImage btn1_pressed = new GreenfootImage("btn_pressed.png");    
    GreenfootImage btn1_hovered = new GreenfootImage("btn_hovered.png");     
    private int cr=5;
    private double aux=0.1;
    String[][] text = new String [4][2];
    int type,btnPosY,lg,typ,mvp;
    private boolean onThis=false;

    String txt;
    int fontSize = 26;
    public Button(int type, int lang)
    {
        sound.setVolume(80);
        text[0][0]="Time Attack";
        text[0][1]="Mod Contra Timp";
        text[1][0]="Puzzle Mode";
        text[1][1]="Mod Puzzle";
        text[2][0]="Tutorial";
        text[2][1]="Tutorial";
        text[3][0]="High Scores";
        text[3][1]="Scoruri";
        
        txt = text[type][lang];
        GreenfootImage t = new GreenfootImage(fontSize*txt.length()+fontSize, fontSize);
        t.setFont(new Font("Serif", Font.PLAIN, fontSize));
        t.setColor(Color.WHITE);
        t.drawString(txt, 22, 20);
        
        btnPosY=240+type*90;
        mvp=335+100*type;
        btn1.drawImage(t,(btn1_pressed.getWidth()-((fontSize/2)*txt.length()+fontSize))/2-25, btn1.getHeight()/2-fontSize/2);
        btn1_hovered.drawImage(t,(btn1_pressed.getWidth()-((fontSize/2)*txt.length()+fontSize))/2-2, btn1.getHeight()/2-fontSize/2);        
        btn1_pressed.drawImage(t,(btn1_pressed.getWidth()-((fontSize/2)*txt.length()+fontSize))/2, btn1_pressed.getHeight()/2-fontSize/2+4);
        setImage(btn1);
        typ = type;
    }
    public void act() 
    {
        //la apasare sa porneasca respectiv butonului

       if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
            
         if(onThis)
            {
                setImage(btn1_hovered); 
                showButtonTooltip();
            }
            else
           {                        
               setImage(btn1);
           }
        
        if (Greenfoot.mouseClicked(this))
            {
                
                setImage(btn1_pressed);
                if(!MuteButton.mute)
                sound.play();
                Greenfoot.delay(5);
                getWorld().showText(" ", 473,640);
                MenuWorld.gamemode = typ + 1;
                
            }
      
      if(getY()>btnPosY)
                moveUp(mvp);      
    } 
    
    void moveUp(int zone)
    {
        setLocation(this.getX(),this.getY()-(int)cr);
        if(getY()<zone && cr>3)
            cr-=aux;
    }
    void showButtonTooltip()
    {
        if(getY()<=btnPosY)
        if(Start.lang==1)
        {
            switch (typ)
            {
                case 0:
                {
                    getWorld().showText("Parcurge cat mai multe labirinturi in 120 secunde.", 473,640);
                    break;
                }
                case 1:
                {
                    getWorld().showText("Colecteaza cele 4 nestemate si iesi din labirint intr-un timp cat mai scurt.", 473,640);
                    break;
                }
                case 2:
                {
                    getWorld().showText("Invata cum se joaca Blackout!", 473,640);
                    break;
                }
                case 3:
                {
                    getWorld().showText("Vezi cele mai bune scoruri obtinute", 473,640);
                    break;
                }                  
            }
        }
        else
        {
           switch (typ)
            {
                case 0:
                {
                    getWorld().showText("Complete as many mazes as possible in 120 seconds.", 473,640);
                    break;
                }
                case 1:
                {
                    getWorld().showText("Collect the 4 gems and escape the maze in as little time as possible.", 473,640);
                    break;
                }
                case 2:
                {
                    getWorld().showText("Learn how to play Blackout!", 473,640);
                    break;
                }
                case 3:
                {
                    getWorld().showText("See your High Scores", 473,640);
                    break;
                }
            }
    
        }
    }
}
