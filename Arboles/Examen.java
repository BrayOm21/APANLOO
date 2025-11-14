package Arboles;
/*Brayan Omar Cabrera Paredes 
 *La diferencia entre este y el examen escrito es que aqui cree un nodo l ya utilizado antes en clase, se declara antes
 * de los metodos y se inicializa con su contructor
 */

public class Examen 
{
    Nodo l;
    Nodo raiz;
    
    public Examen()
    {
        raiz=null;
        l=null;
    }

    private Nodo ponLigasGenracion(Nodo sa, Nodo ant, int nivel, int gen)
    {
        if(sa==null)
        {
            return ant;
        }
        if(nivel==gen)
        {
            if(ant==null)
            {
                l=sa;
            }
            else
            {
                ant.sig=sa;
                sa.prev=ant;
            }
            ant=sa;
        }
        ant=ponLigasGenracion(sa.hizq, ant, nivel+1, gen);
        ant=ponLigasGenracion(sa.hder, ant, nivel+1, gen);
        return ant; 
    }
    public void ponLigasGenracion(int gen)
    {
        ponLigasGenracion(raiz, l, 1, gen);
    }

    private Nodo ponLigasHojas(Nodo sa, Nodo ant)
    {
        if(sa==null)
        {
            return ant;
        }
        ant=ponLigasHojas(sa.hizq,ant);
        if(sa.hizq==null&&sa.hder==null)
        {
            if(ant==null)
            {
                l=sa;
            }
            else
            {
                ant.sig=sa;
                sa.prev=ant;
            }
            ant=sa;
        }
        ant=ponLigasHojas(sa.hder,ant);
        return ant;
    }
    public void ponLigasHojas()
    {
        ponLigasHojas(raiz,null);
    }

    private int sumaNodosHastaNivel(Nodo sa,int nivel, int lim)
    {
        if(sa==null)
        {
            return 0;
        }
        if(nivel>lim)
        {
            return 0;
        }
        int suma = sa.info;
        suma+=sumaNodosHastaNivel(sa.hizq, nivel+1, lim);
        suma+=sumaNodosHastaNivel(sa.hder, nivel+1, lim);
        return suma;
    }
    public int sumaNodosHastaNivel(int nivel)
    {
        return sumaNodosHastaNivel(raiz,1,nivel);
    }
}
