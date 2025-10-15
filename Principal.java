package APANLOO;

public class Principal 
{
    public static void main(String[] args) 
    {
        Lista lista = new Lista();
        lista.insertaFinal(2);
        lista.insertaFinal(3);
        lista.insertaFinal(4);
        lista.insertaFinal(8);
        System.out.println(" ");
        System.out.println(lista);
        System.out.println("El numero total de Nodos de la ista es: " +lista.contarNodosR());
        System.out.println("La suma de los elementos de la lista es: " +lista.contarElemNodoR());
    }   
}
