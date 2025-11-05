package Arboles;
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
    public String imprimir()
    {
        return imprimir(raiz);
    }

    private boolean completo(Nodo raiz)
    {
        if(raiz == null)
        {
            return true;
        }
        LinkedList<Nodo> l = new LinkedList<>();
        l.add(raiz);
        int numNodo = 1;
        while(!l.isEmpty())
        {
            int nivel = l.size();
            if(nivel != numNodo)
            {
                return false;
            }
            numNodo *=2;

            for(int i = 0; i<nivel; i++)
            {
                Nodo aux = l.remove(0);
                if(aux.hizq!=null)
                {
                    l.add(aux.hizq);
                }
                if(aux.hder!=null)
                {
                    l.add(aux.hder);
                }
            }
        }
        return true;
    }
    public boolean completo()
    {
        return completo(raiz);
    }

    private int completoR(Nodo sa)
    {
        if(sa == null)
        {
            return 0;
        }
        int izq = completoR(sa.hizq);
        int der = completoR(sa.hder);
        if(izq == -1 || der == -1)
        {
            return -1;
        }  
        if(izq != der)
        {
            return -1;
        }
        return izq+1;
    }

    public boolean completoR()
    {
        if(completoR(raiz)>=0)
        {
            return true;
        }
        return false;
    }

    private boolean lleno(Nodo raiz)
    {
        LinkedList<Nodo> l = new LinkedList<>();
        l.add(raiz);

        while(!l.isEmpty())
        {
            int nivel =l.size();
            boolean nulo=false;
            for(int i = 0; i<nivel; i++)
            {
                Nodo aux = l.remove(0);
                if(nulo && aux !=null)
                {
                    return false;
                }
                nulo = aux==null;
                if(aux!=null)
                {
                    l.add(aux.hizq);    
                    l.add(aux.hder);
                }
            }
        }
        return true;
    }
    public boolean lleno()
    {
        return lleno(raiz);
    }
    private String arbolString(Nodo sa)
    {
        if(sa==null)
        {
            return "";
        }
        String si=arbolString(sa.hizq);
        String sd=arbolString(sa.hder);
        if(si.length() == 0 && sd.length()==0)
        {
            return ""+sa.info;
        } 
        if(si.length() == 0)
        {
            return ""+sa.info+"(,"+sd+")";
        }
        if(sd.length()==0)
        {
            return ""+sa.info+"("+si+")";
        }
        return ""+sa.info+"("+si+","+sd+")";
    }
    @Override
    public String toString()
    {
        return arbolString(raiz);
    }

    private Nodo insOrdenado(Nodo sa, int info)
    {
        if(sa==null)
        {
            return new Nodo(info);
        }
        if(info>sa.info)
        {
            sa.hder = insOrdenado(sa.hder, info);
        }
        else
        {
            sa.hizq = insOrdenado(sa.hizq, info);
        }
        return sa;
    }
    public void insOrdenado(int info)
    {
        raiz = insOrdenado(raiz, info);
    }

    private Nodo borraPred(Nodo sa, int [] info)
    {
        if(sa == null)
        {
            return null;
        }
        if(sa.hder == null)
        {
            info[0]=sa.info;
            return sa.hizq;
        }
        sa.hder = borraPred(sa.hder, info);
        return sa;
    }

    private Nodo borraRaiz(Nodo sa)
    {
        if(sa==null)
        {
            return null;
        }
        if(sa.hizq == null)
        {
            return sa.hder;
        }
        if(sa.hder == null)
        {
            return sa.hizq;
        }
        int [] info = new int[1];
        sa.hizq=borraPred(sa.hizq, info);
        sa.info = info[0];
        return sa;
    }
    public void borraRaiz()
    {
        raiz = borraRaiz(raiz);
    }

    private Nodo buscayBorra(Nodo sa, int info)
    {
        if(sa == null)
        {
            return null;
        }
        if(sa.info==info)
        {
            return borraRaiz(sa);
        }
        if(info > sa.info)
        {
            sa.hder=buscayBorra(sa.hder, info);
        }
        else
        {
            sa.hizq = buscayBorra(sa.hizq, info);
        }
        return sa;
    }
    public void buscayBorra(int info)
    {
        raiz = buscayBorra(raiz, info);
    }
    private boolean esABB(Nodo sa, int min, int max)
    {
        if(sa == null)
        {
            return true;
        }
        if(sa.info>min && sa.info<max)
        {
            return esABB(sa.hizq, min, sa.info) && esABB(sa.hder, sa.info, max);
        }
        return false;
    }
    public boolean esABB()
    {
        return esABB(raiz,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean esDegenerado(Nodo sa)
    {
        if(sa == null)
        {
            return true;
        }
        if(sa.hizq != null && sa.hder!= null)
        {
            return false;
        }
        return esDegenerado(sa.hizq) && esDegenerado(sa.hder);
    }
    public boolean esDegenerado()
    {
        if(raiz == null)
        {
            return false;
        }
        return esDegenerado(raiz);
    }
}
