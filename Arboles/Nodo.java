package Arboles;
public class Nodo 
{
    int info;
    Nodo hizq, hder;
    Nodo prev,sig;
    public Nodo(int info)
    {
        this.info=info;
        hizq=hder=prev=sig=null;
    }
}
