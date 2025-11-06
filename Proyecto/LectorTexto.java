package Proyecto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LectorTexto 
{
    static public void leeTexto(String arch) throws FileNotFoundException, IOException
    {
        //Abre el archivo como de lectura
        RandomAccessFile f = new RandomAccessFile(arch, "r");
        String l;
        while ((l=f.readLine())!=null)
        {
            System.out.println(l);
        }
        f.close();
    } 
    
}
