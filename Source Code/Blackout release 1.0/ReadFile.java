/**
 * ReadFile
 * Clasa care permite citirea dintr-un fisier text a unei valori.
 */
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile  
{

    
    private String path;    
    public ReadFile(String file_path)
    {
        path = file_path;
        
    }
    public String OpenFile() throws IOException
    {
        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);
        String textData = new String();
        textData = textReader.readLine();
        textReader.close( );
        return textData;        
    }
}
