package Grafos;

import java.util.LinkedList;
import java.util.List;

public class CaminoCosto 
{
    private int costo;
    private List<Integer> camino;

    public CaminoCosto()
    {
        costo = Integer.MAX_VALUE;
        camino = null;
    }

    public CaminoCosto(int costo, List<Integer> camino)
    {
        this.camino = new LinkedList<>();
        for(int n: camino)
        {
            this.camino.add(n);
        }
        this.costo=costo;
    }

    public int getCosto()
    {
        return this.costo;
    }
    public List<Integer> getCamino()
    {
        return this.camino;
    }
    public void setCosto(int costo)
    {
        this.costo=costo;
    }
    public void setCamino(List<Integer> camino)
    {
        this.camino=new LinkedList<>();
        for(int n: camino)
        {
            this.camino.add(n);
        }
    }

    @Override
    public String toString()
    {
        String aux = String.format("Costo = %d Camino:", this.costo );
        int numNodo=1;
        if(this.camino==null)
        {
            return "No existe un camino";
        }
        for(int i:this.camino)
        {
            if(numNodo>1)
            {
                aux=aux.concat(",");
            }
            aux=aux.concat(Integer.toString(i));
            numNodo++;
        }
        return aux;
    }

}
