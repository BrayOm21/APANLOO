package Arboles;
public class Main 
{
    public static void main(String[] args) 
    {
        Arbol a = new Arbol();
        //a = a.ejemplo2();
        //Arbol a = a.ejemplo2();
        //a.postOrden();
        //System.out.println("\nEl numero de Nodos totales en el arbol es: " + a.numNodos());
        //System.out.println("La suma de los elementos del Arbol es: " +a.sumNodos());
        //System.out.println("El mayor dato del arbol es: "+a.valMayNodos());
        //System.out.println(a.iguales(b));
        //System.out.println();
        //System.out.println(a.imprimir());
        //System.out.println(a.lleno());
        a.insOrdenado(1);
        a.insOrdenado(2);
        a.insOrdenado(3);
        a.insOrdenado(4);
        a.insOrdenado(5);
        a.insOrdenado(6);
        a.insOrdenado(7);
        a.insOrdenado(8);
        a.insOrdenado(9);
        a.insOrdenado(10);
        //System.out.println(a);
        //a.borraRaiz( );
        //  System.out.println(a);
        System.out.println(a.esDegenerado());
    }   
}
