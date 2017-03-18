/**
 * ReadFile
 * Clasa care permite scrierea intr-un fisier text a unei valori.
 */
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class WriteFile
{
    private String path;
    
    public WriteFile( String file_path )
    {

        path = file_path;

    }
    //Functie de scriere in fisier a unei valori
    public void writeToFile( String textLine ) throws IOException 
    {
        //deschiderea fisierului
        FileWriter write = new FileWriter(path, false);
        PrintWriter print_line = new PrintWriter(write);
        //scrierea in el a valorii noi
        print_line.printf( "%s" + "%n" , textLine);
        print_line.close();
 
    }    

}
