package APANLOO.Arboles;
public class Main 
{
    public static void main(String[] args) 
    {
        Arbol a = new Arbol();
        a = a.ejemplo1();
        Arbol b = a.ejemplo2();
        a.postOrden();
        System.out.println("\nEl numero de Nodos totales en el arbol es: " + a.numNodos());
        System.out.println("La suma de los elementos del Arbol es: " +a.sumNodos());
        System.out.println("El mayor dato del arbol es: "+a.valMayNodos());
        System.out.println(a.iguales(b));
    }
    
}
