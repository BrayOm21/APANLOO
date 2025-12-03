package Grafos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Set;
import java.util.List;

public class Grafo 
{
    public Grafo()
    {
        adj=null;
    }
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

    public void  recorridoProfundidad(int v)
    {
        int [] marcados = new int[adj.length];
        Stack<Integer> pila = new Stack<>();
        int w;
        for(int i=0; i<marcados.length; i++)
        {
            marcados[i]=0;
        }
        marcados[v]=1;
        pila.push(v);
        while(!pila.isEmpty())
        {
            w=pila.pop();
            System.out.println(w);
            for(int i=0; i<adj[w].length; i++)
            {
                if(adj[w][i] != 0 && marcados[i]==0)
                {
                    pila.push(i);
                    marcados[i]=1;
                }
            }
        }
    }

    public Set<Integer> recorridoProfundidadSet(int v)
    {
        int [] marcados = new int [adj.length];
        Set<Integer> aux= new TreeSet<>();
        Stack<Integer> pila = new Stack<>();
        int w;
        for(int i = 0; i<marcados.length; i++)
        {
            marcados[i]=0;
        }
        marcados[v]=1;
        pila.push(v);
        while (!pila.isEmpty()) 
        {
            w=pila.pop();
            aux.add(w);
            for(int i =0; i<adj[w].length; i++)
            {
                if(adj[w][i] !=0 && marcados[i]==0)
                {
                    pila.push(i);
                    marcados[i]=1;
                }
            }
        }
        return aux;
    }

    public List<Set<Integer>> componentesConexas()
    {
        List<Set<Integer>> componentes = new LinkedList<Set<Integer>>();
        Set<Integer> marcados = new TreeSet<>();
        for(int i=0; i<adj.length; i++)
        {
            if(!marcados.contains(i))
            {
                Set<Integer> unacomp = recorridoProfundidadSet(i);
                unacomp.stream().forEach((k) -> {
                    marcados.add(k);
                });
                componentes.add(unacomp);
            }
        }
        return componentes;
    }
    
    public List<Set<Integer>> componentesFuertementeConexas()
    {
        List<Set<Integer>> componentes = new LinkedList<Set<Integer>>();
        Set<Integer> marcados = new TreeSet<>();
        Grafo inversa = cloneInv();
        Set<Integer> unaComp;
        Set<Integer> unaCompInv;
        Set<Integer> unaCompFte;
        for(int i=0; i<adj.length; i++)
        {
            if(!marcados.contains(i))
            {
                unaComp=recorridoProfundidadSet(i);
                unaCompInv=inversa.recorridoProfundidadSet(i);
                unaCompFte=new TreeSet<>();
                unaComp.retainAll(unaCompInv);
                componentes.add(unaComp);
                marcados.addAll(unaComp);
            }
        }
        return componentes;
    }

    public void muestraComponentes(List<Set<Integer>> componentes)
    {
        for(Set<Integer> unaC : componentes)
        {
            for(int v:unaC)
            {
                System.out.print(v);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public Grafo cloneInv()
    {
        Grafo aux = new Grafo();
        aux.adj = new int[this.adj.length][this.adj.length];
        for(int i=0; i<this.adj.length;i++)
        {
            for(int j=0; j<this.adj[i].length;j++)
            {
                aux.adj[j][i]=this.adj[i][j];
            }
        }
        return aux;
    }

    private int [][] sumaMatriz(int [][] a, int [][] b)
    {
        int[][] aux= new int[this.adj.length][this.adj.length];
        for(int i=0; i<this.adj.length;i++)
        {
            for(int j=0; j<this.adj.length; j++)
            {
                aux[i][j]=a[i][j]+b[i][j];
                if(aux[i][j]>0)
                {
                    aux[i][j]=1;
                }
            }
        }
        return aux;    
    }

    private int [][] multiplicaMatricez(int [][]ent)
    {
        int [][] aux = new int[this.adj.length][this.adj.length];
        for(int i=0; i<this.adj.length; i++)
        {
            for(int j=0; j<this.adj.length; j++)
            {
                for(int k=0; k<this.adj.length; k++)
                {
                    aux[i][j]=aux[i][j]+ent[i][j]*this.adj[k][j];
                }
                if(aux[i][j]>0)
                {
                    aux[i][j]=1;
                }
            }
        }
        return aux;
    }

    public Grafo cierreTransitivo()
    {
        int[][] suma=new int [this.adj.length][this.adj.length];
        int[][] mul=new int [this.adj.length][this.adj.length];
        for(int i=0; i<this.adj.length; i++)
        {
            System.arraycopy(this.adj[i], 0, suma[i],0 , this.adj.length);
        }
        int i;
        for(i=0; i<this.adj.length; i++)
        {
            if(i==0)
            {
                mul=multiplicaMatricez(this.adj);
            }
            else
            {
                mul=multiplicaMatricez(mul);
            }
            suma=sumaMatriz(suma, mul);
        }
        Grafo g=new Grafo();
        g.adj=suma;
        return g;
    }

    public Grafo algoritmoWarshall()
    {
        int [][] aux= new int[adj.length][adj.length];
        for(int i=0; i<this.adj.length;i++)
        {
            System.arraycopy(this.adj[i],0,aux[i],0,this.adj.length);
        }

        for(int k=0; k<adj.length;k++)
        {
            for(int i=0; i<adj[k].length;i++)
            {
                for(int j=0; j<adj.length; j++)
                {
                    aux[i][j]=aux[i][j]!=0 || (aux[i][k]!=0 && aux[k][j] !=0)?1:0;
                }
            }
        }
        Grafo g = new Grafo();
        g.adj = aux; 
        return g;
    }

    private void caminoMasCortoR(CaminoCosto actual, int costo, List<Integer> p, int org, int dest)
    {
        if(org==dest)
        {
            if(actual.getCosto()>costo)
            {
                actual.setCosto(costo);
                actual.setCamino(p);
            }
            return;
        }
        for(int i=0; i<adj[org].length;i++)
        {
            if(adj[org][i]==0)
            {
                continue;
            }
            if(p.contains(i))
            {
                continue;
            }
            p.add(i);
            costo += adj[org][i];
            if(costo >actual.getCosto())
            {
                costo -= adj[org][i];
                p.remove(p.indexOf(i));
                continue;
            }
            caminoMasCortoR(actual, costo, p, i, dest);
            costo-=adj[org][i];
            p.remove(p.indexOf(i));
        }
    }
    public CaminoCosto caminoMasCortoR(int org, int dest)
    {
        CaminoCosto actual= new CaminoCosto();
        List<Integer> p = new LinkedList<>();
        p.add(org);
        caminoMasCortoR(actual, 0, p, org, dest);
        return actual;
    }
    
    public int [][] algoritmoDijkstra(int origen)
    {
        int [][] d= new int[adj.length][2];
        boolean [] f = new boolean[adj.length];
        for(int i=0; i<this.adj.length; i++)
        {
            if(i==origen)
            {
                f[i]=true;
            }
            else
            {
                f[i]=false;
            }
            if(this.adj[origen][i]!=0)
            {
                d[i][0]=this.adj[origen][i];
            }
            else
            {
                d[i][0]=Integer.MAX_VALUE-1000;
            }
            d[i][1]=origen;
        }
        int nodoMin;
        int costoMin;
        for(int i=0; i<this.adj.length;i++)
        {
            nodoMin=0;
            costoMin=Integer.MAX_VALUE-1000;
            for(int j=0; i<this.adj.length;j++)
            {
                if(f[j])
                {
                    continue;
                }
                if(costoMin>=d[j][0])
                {
                    costoMin=d[j][0];
                    nodoMin=j;
                }
            }
            f[nodoMin]=true;
            for(int w=0;w<this.adj.length;w++)
            {
                if(f[w])
                {
                    continue;
                }
                if((d[nodoMin][0]+(this.adj[nodoMin][w]==0?Integer.MAX_VALUE-1000)))
            }
        }
    }
}
