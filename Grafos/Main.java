package Grafos;

public class Main 
{
    public static void main(String[] args) 
    {
        Grafo g;
        g=new Grafo("C:\\Users\\braya\\Documents\\Git\\APANLOO\\Grafos\\g1.txt");
        System.out.println("Matriz");
        g.impreMatriz();
        g.recorridoAnchura(0);
    } 
}
