package Proyecto;
import java.util.*;
public class Main 
{
    public static void main(String[] args) 
    {     
        String arch = "C:\\Users\\ldcbi\\Documents\\LabBOCP\\APANLOO\\Proyecto\\romeo.txt";
        List<String> lineas = LectorTexto.leeTexto(arch);
        AnalizadorTexto analizador = new AnalizadorTexto();
        analizador.analizadorTexto(lineas);
        analizador.mostrarDatos();
    }   
}
