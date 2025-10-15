package APANLOO;

public class Principal 
{
    public static void main(String[] args) 
    {
        Lista lista = new Lista();

        lista.insertaFinalR(2);
        lista.insertaFinalR(3);
        lista.insertaFinalR(4);
        lista.insertaFinalR(8);
        System.out.println("El numero total de Nodos es: " +lista.contarNodos());
        lista.mostrar();
    }   
}
