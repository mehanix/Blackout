import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Generator
 * Clasa principala a jocului
 * 
 * Genereaza un labirint de dimensiunile (row*2,col*2)
 * Cum functioneaza generarea labirintului:
 ***Daca se mai poate adauga un perete
 ***In functie de cea care este mai mare, lungimea sau latimea
 ***Se imparte pe orizontala sau verticala
 ***Daca lungime = latime, se alege aleatoriu direcia pe care sa se imparta labirintul
 ***Apoi se alege aleatoriu pe zidul creat o pozitie care va reprezenta calea de acces dintre cele doua zone
 ***
 ***Impartire = generarea unui perete care separa labirintul in 2 zone diferite
 ***
   * 
 */
public class Generator extends Actor
{
    //Cifra cu care peretele este marcat in matrice
    static final int WALL = 1;
   
    //Cifra care semnifica pe unde se poate merge in labirint
    static final int MAZE_PATH = 0;

    int rows;
    int cols;
    int act_rows;
    int act_cols;

    int[][] board;

    public Generator(int row, int col)
    {
        //dublarea numarului de linii si coloane(astfel ne asiguram ca se poate face
        //macar o impartire a labirintului
        rows = row*2+1;
        cols = col*2+1;
        act_rows = row;
        act_cols = col;
        
        //crearea matricei si bordarea ei cu pereti
        board = new int[rows*3][cols*3];
        for(int i=0; i<rows; i++){
            board[i][0] = WALL;
            board[i][cols-1] = WALL;
        }

        for(int i=0; i<cols; i++){
            board[0][i] = WALL;
            board[rows-1][i] = WALL;
        }


    }

    public void makeMaze()
    {
        makeMaze(0,cols-1,0,rows-1);
    }

    //generarea labirintului
    private void makeMaze(int left, int right, int top, int bottom)
    {
        //calculeaza dimensiunile zonei curente
        int width = right-left;
        int height = bottom-top;
        //impartire in functie de dimensiunile zonei
        if(width > 2 && height > 2){

            if(width > height)
                divideVertical(left, right, top, bottom);

            else if(height > width)
                divideHorizontal(left, right, top, bottom);

            else if(height == width){
                Random rand = new Random();
                int pickOne = Greenfoot.getRandomNumber(2);

                if(pickOne==1)
                    divideVertical(left, right, top, bottom);
                else
                    divideHorizontal(left, right, top, bottom);
            }
        }else if(width > 2 && height <=2){
            divideVertical(left, right, top, bottom);
        }else if(width <=2 && height > 2){
            divideHorizontal(left, right, top, bottom);
        }
    }

    private void divideVertical(int left, int right, int top, int bottom)
    {
        //impartire pe verticala
        Random rand = new Random();
        int divide =  left + 2 + rand.nextInt((right-left-1)/2)*2;
        for(int i=top; i<bottom; i++){
            board[i][divide] = WALL;
        }
        
        //crearea unui spatiu de trecere in peretele generat, pentru a permite trecerea
        //dintr-o zona a labirintului in cealalta
        //astfel, nu va exista nicio zona inaccesibila in labirint
        int clearSpace = top + rand.nextInt((bottom-top)/2) * 2 + 1;
        board[clearSpace][divide] = MAZE_PATH;     
        //reapeleaza functia de impartire pe cele doua zone noi create
        makeMaze(left, divide, top, bottom);
        makeMaze(divide, right, top, bottom);
    }

    private void divideHorizontal(int left, int right, int top, int bottom)
    {
         //impartire pe orizontala
        Random rand = new Random();
        int divide =  top + 2 + rand.nextInt((bottom-top-1)/2)*2;
        if(divide%2 == 1)
            divide++;

        for(int i=left; i<right; i++){
            board[divide][i] = WALL;
        }
        //crearea unui spatiu de trecere in peretele generat, pentru a permite trecerea dintr-o zona a labirintului in cealalta
        //astfel, nu va exista nicio zona inaccesibila in labirint
        int clearSpace = left + rand.nextInt((right-left)/2) * 2 + 1;
        //reapeleaza functia de impartire pe cele doua zone noi create
        board[divide][clearSpace] = MAZE_PATH;
        makeMaze(left, right, top, divide);
        makeMaze(left, right, divide, bottom);
    }

    //metode de returnare a labirintului si dimensiunilor lui
    public int[][] getMaze(){
        return board;
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    //metoda folosita de restul obiectelor, cat si a Playerului, care alege o pozitie aleatorie neocupata din labirint,
    //o marcheaza ca fiind folosita, si o returneaza
    public int[] getRandomEmptyPosition()
    {
        int x=0,y=0;
        int[] xy = new int[2];
        x=Greenfoot.getRandomNumber(getRows());
        y=Greenfoot.getRandomNumber(getCols());        
        while(board[x][y]!=0)
        {
            x=Greenfoot.getRandomNumber(getRows());
            y=Greenfoot.getRandomNumber(getCols());
        }
        board[x][y]=3;
        xy[0]=x;
        xy[1]=y;
        return xy;
    }
    
    }


