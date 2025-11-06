package Proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AnalizadorTexto 
{
    //Se crea el objeto de la clase treeMap
    private TreeMap<String, ArrayList<int[]>> mapaPalabras = new TreeMap<>();
    //Metodo para analizar el texto linea por linea, separarlo en palabras y guardar las coordenadas
    public void analizadorTexto(List<String> lineas)
    {
        //Recorremos la lista para saber una coordenada fila
        for(int fila=0; fila<lineas.size(); fila++)
        {
            //Creamos un string en dodne obtenemos un elemento de la lista
            String linea = lineas.get(fila);
            //Creamos un arreglo en donde separaremos la fila en palabras 
            String [] palabras = linea.split("\\s+");
            //Este segundo for es para recorrer el nuevo arreglo de String y saber la otra coordenada columna
            for(int columna=0; columna<palabras.length; columna++)
            {
                //La palabra que tenemos en un indice de el arreglo la convertimos a mayuscula
                String palabra= palabras[columna].toUpperCase();
                //Si no tenemos la palabra creamos un nuevo bodo de TreeMap y si existe pasamos a la siguiente linea
                mapaPalabras.putIfAbsent(palabra, new ArrayList<>());
                //Asignamos las coordenadas fila y columna
                mapaPalabras.get(palabra).add(new int[]{fila+1,columna+1});
            }
        }
    }
       
}
