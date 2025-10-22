package APANLOO.Arboles;
import java.util.LinkedList;
public class Arbol 
{
    Nodo raiz;
    
    public Arbol()
    {
        raiz=null;
    }
    public Arbol ejemplo1()
    {
        Arbol a = new Arbol();//crear arbol
        a.raiz = new Nodo(1);//crear raiz
        a.raiz.hizq = new Nodo(2);
        a.raiz.hder = new Nodo(3);
        a.raiz.hizq.hizq = new Nodo(4);
        a.raiz.hizq.hder = new Nodo(5);
        a.raiz.hder.hder = new Nodo(6);
        a.raiz.hder.hder.hizq = new Nodo(7);
        return a;
    }

    public Arbol ejemplo2()
    {
        Arbol a = new Arbol();//crear arbol
        a.raiz = new Nodo(1);//crear raiz
        a.raiz.hizq = new Nodo(2);
        a.raiz.hder = new Nodo(3);
        a.raiz.hizq.hizq = new Nodo(4);
        a.raiz.hizq.hder = new Nodo(5);
        a.raiz.hder.hder = new Nodo(6);
        a.raiz.hder.hder.hder = new Nodo(7);
        return a;
    }

    private void preOrden(Nodo sa)
    {
        //Si no hay subArbol
        if(sa == null)
        {
            return;
        }
        //Visita raiz
        System.out.print(sa.info);
        //Visita subArbol izq
        preOrden(sa.hizq);
        //visita subArbol der
        preOrden(sa.hder);
    }
    public void preOrden()
    {
        preOrden(raiz);
    }

    private void enOrden(Nodo sa)
    {
        //Si no hay subArbol
        if(sa == null)
        {
            return;
        }
        //Visita subArbol izq
        enOrden(sa.hizq);
        //Visita raiz
        System.out.print(sa.info);
        //visita subArbol der
        enOrden(sa.hder);
    }
    public void enOrden()
    {
        enOrden(raiz);
    }

    private void postOrden(Nodo sa)
    {
        //Si no hay subArbol
        if(sa == null)
        {
            return;
        }
        //Visita subArbol izq
        postOrden(sa.hizq);
        //visita subArbol der
        postOrden(sa.hder);
        //Visita raiz
        System.out.print(sa.info);
    }
    public void postOrden()
    {
        postOrden(raiz);
    }

    private int numNodos(Nodo sa)
    {
        //subArbol vacio
        if (sa == null) 
        {
            return 0;
        }
        return numNodos(sa.hizq)+numNodos(sa.hder)+1;
    }
    public int numNodos()
    {
        return numNodos(raiz);
    }

    private int sumNodos(Nodo sa)
    {
        //subArbol vacio
        if (sa == null) 
        {
            return 0;
        }
        return sumNodos(sa.hizq)+sumNodos(sa.hder)+sa.info;
    }
    public int sumNodos()
    {
        return sumNodos(raiz);
    }

    private int valMayNodos(Nodo sa)
    {
        //subArbol vacio
        if (sa == null) 
        {
            return Integer.MIN_VALUE;
        }
        int uno = valMayNodos(sa.hizq);
        int dos = valMayNodos(sa.hder);
        return Math.max(sa.info, Math.max(uno,dos));
    }
    public int valMayNodos()
    {
        return valMayNodos(raiz);
    }

    private boolean iguales(Nodo ar1, Nodo ar2)
    {
        if(ar1 == null && ar2 == null)
        {
            return true;
        }
        if(ar1 == null || ar2 == null)
        {
            return false;
        }
        return ar1.info == ar2.info && iguales(ar1.hder, ar2.hder) && iguales(ar1.hder,ar2.hder); 
    }
    public boolean iguales(Arbol a)
    {
        return iguales(raiz, a.raiz);
    }
    private String imprimir(Nodo raiz)
    {
        if(raiz == null)
        {
            return "";
        }
        LinkedList<Nodo> l = new LinkedList<>();
        l.add(raiz);
        String sal = "";
        while(!l.isEmpty())
        {
            int nivel = l.size();
            String tem = "";
            for(int i = 0; i<nivel; i++)
            {
   
                Nodo aux = l.remove(0);
                if(tem.length()==0)
                {
                    tem=""+aux.info;
                }
                else
                {
                    tem=tem+","+aux.info;
                }
                if(aux.hizq!=null)
                {
                    l.add(aux.hizq);
                }
                if(aux.hder!=null)
                {
                    l.add(aux.hder);
                }
            }
            if(sal.length() == 0)
            {
                sal=tem;
            }
            else
            {
                sal = sal + "\n" + tem;
            }
        }
        return sal;
    }

}
