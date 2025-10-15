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

    public void mostrar()
    {
        for(Nodo aux=inicio; aux!=null; aux=aux.sig)
        {
            System.out.print("[ " + aux.info + " ] -- ");
        }
        System.out.println("null");
    }
}
