import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main2 
{
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        leeTexto("C:\\Users\\braya\\Documents\\Git\\APANLOO\\Proyecto\\romeo.txt");
    }
    public static void palabra(String texto)
    {
        String[] palabras = texto.split(" ");
        for (int i=0; i<palabras.length; i++) 
        {
            System.out.println(palabras[i]);
        }
    }
    
    /* Leer un archivo en formato texto */
    static public void leeTexto(String arch) throws FileNotFoundException, IOException
    {
        //Abre el archivo como de lectura
        RandomAccessFile f = new RandomAccessFile(arch, "r");
        String l;
        while ((l=f.readLine())!=null){
            palabra(l);
        }
        f.close();
    }


}
