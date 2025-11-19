package Grafos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo 
{
    int [][] adj;

    boolean esunaLetra(char a)
    {
        return Character.isLetter(a)||Character.isDigit(a);
    }
    public Grafo(String origen) 
    {
        String tipo = " ";
        try
        {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(origen);
            try (DataInputStream in = new DataInputStream(fstream)) 
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                //Read File Line By Line
                int i = 1;
                int tripleta;
                int org = 0, dest=0, peso=0;            
                while ((strLine = br.readLine()) != null)   
                {
                    // Print the content on the console
                    //System.out.println (i++  +  " "+strLine);
                    char [] Arr = strLine.toCharArray(); 
                    int j = 0;
                    tripleta = 1;
                    while (j<Arr.length)
                    {
                        //come blancos
                        while (j<Arr.length && !esunaLetra(Arr[j]))
                        {
                            j++;
                        }
                        //come distintos de blancos
                        int k = j;
                        while (k<Arr.length && esunaLetra(Arr[k]))
                        {
                            k++;
                        }
                        if ((k-j)<1) continue;
                        //depende del renglon
                        if (i == 1)
                        {
                            tipo = strLine.substring(j, k);
                            System.out.println("tipo =" + tipo);
                        }
                        //obtiene el tamaño de la matrix
                        if (i==2)
                        {
                            int tam = Integer.parseUnsignedInt(strLine.substring(j, k));
                            adj = new int[tam][tam];
                            System.out.println("tam =" + String.valueOf(tam));
                        }
                        //Es una tripleta
                        if (i>2)
                        {
                            switch(tripleta) 
                            {
                                case 1: org = Integer.parseUnsignedInt(strLine.substring(j, k));
                                    tripleta++;
                                    break;
                                case 2: dest = Integer.parseUnsignedInt(strLine.substring(j, k));
                                    tripleta++;
                                    break;
                                case 3: peso = Integer.parseUnsignedInt(strLine.substring(j, k));
                                    //le pone el peso a la matriz
                                    adj[org][dest]=peso;
                                    if (!tipo.contentEquals("D"))
                                    {
                                        adj[dest][org]=peso;
                                    }
                                System.out.println(String.valueOf(org) + " "+  String.valueOf(dest) + "  "+  String.valueOf(peso));  
                            } 
                        }
                        j = k;
                    }        
                    i++;
                }
            }
        }catch (Exception e)
        {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        } 
    }
    public void impreMatriz()
    {
        int i,j;
        for(i=0; i<adj.length; i++)
        {
            for(j=0; j<adj.length; j++)
            {
                System.out.print(adj[i][j]);
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

    public void recorridoAnchura(int v)
    {
        int [] marcados = new int[adj.length];
        Queue<Integer> cola = new LinkedList<>();
        int w;
        for(int i=0; i<marcados.length; i++)
        {
            marcados[i]=0;
        }
        marcados[v]=1;
        cola.add(v);
        while(!cola.isEmpty())
        {
            w=cola.poll();
            System.out.println(w);
            for(int i=0; i<adj[w].length; i++)
            {
                if(adj[w][i] != 0 && marcados[i]==0)
                {
                    cola.add(i);
                    marcados[i]=1;
                }
            }
        }
    }
}
