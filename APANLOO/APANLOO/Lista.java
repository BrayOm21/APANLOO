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
            for(aux = inicio; aux.sig != null; aux=aux.sig);
            aux.sig = nuevo;
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
    private int contarNodosR(Nodo l, int N)
    {
        if(l == null)
        {
            return N;
        }
        return (contarNodosR(l.sig,N+1));
    }
    public int contarNodosR()
    {
        return contarNodosR(inicio,0);
    }

    public int contarElemNodo()
    {
        int N = 0;
        Nodo aux;
        for(aux = inicio; aux != null; aux=aux.sig)
        {
            N+=aux.info;
        }
        return N;
    }
    private int contarElemNodoR(Nodo l, int N)
    {
        if(l == null)
        {
            return N;
        }
        return (contarElemNodoR(l.sig, N+=l.info));
    }
    public int contarElemNodoR()
    {
        return contarElemNodoR(inicio,0);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (Nodo aux = inicio; aux != null; aux = aux.sig)
        {
            sb.append("[ ").append(aux.info).append(" ]-->");
        }
        sb.append("null");
        return sb.toString();
    }
}
