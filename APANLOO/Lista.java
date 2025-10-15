package APANLOO;

public class Lista 
{
    Nodo inicio;

    public Lista()
    {
        inicio=null;
    }
    
    public void insertaFrente(int dato)
    {
        Nodo nuevo  = new Nodo(dato);
        if(inicio == null)
        {
            inicio = nuevo;
        }
        else
        {
            nuevo.sig = inicio;
            inicio = nuevo;
        }
    }

    public void insertaFinal(int dato)
    {
        Nodo nuevo = new Nodo(dato);
        if(inicio == null)
        {
            inicio = nuevo;
        }
        else
        {
            Nodo aux;
            for(aux = inicio; aux.sig!=null; aux=aux.sig);
            if(aux.sig == null)
            {
                aux.sig=nuevo;
            }
        }
    }

    private Nodo insertaFinalR(Nodo a, int info)
    {
        if(a == null)
        {
            return new Nodo(info);
        }
        a.sig = insertaFinalR(a.sig,info);
        return a;
    }
    public void insertaFinalR(int info)
    {
        inicio = insertaFinalR(inicio, info);
    }

    public int contarNodos()
    {
        int N = 0;
        Nodo aux;
        for(aux = inicio; aux != null; aux=aux.sig, N++);
        return N;
    }

    public void mostrar()
    {
        for(Nodo aux=inicio; aux!=null; aux=aux.sig)
        {
            System.out.print("[ " + aux.info + " ] -- ");
        }
        System.out.println("null");
    }
}
