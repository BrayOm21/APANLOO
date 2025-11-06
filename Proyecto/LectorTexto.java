package Proyecto;

import java.io.*;
import java.util.*;

public class LectorTexto 
{
    public static List<String> leeTexto(String arch)
    {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(arch), "UTF-8")))
        {        
            String l;
            while ((l=br.readLine())!=null)
            {
                lineas.add(l);
            }
        }
        catch(IOException e)
        {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    } 
    
}
