public class Prueba 
{ 
    public static void palabra(String texto)
    {
        String[] palabras = texto.split(" ");
        for (String palabra : palabras) 
        {
            System.out.println(palabra);
        }
    }
}
