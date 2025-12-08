package Grafos;

public class Main 
{
    public static void main(String[] args) 
    {
        Grafo g;
        System.out.println("Floyd");
        g = new Grafo("C:\\Users\\braya\\Documents\\Git\\APANLOO\\Grafos\\g1.txt");
        g.impreMatriz();
        /*Grafo[] floyd = g.algoritmoFloyd();
        System.out.println("Floyd");
        floyd[0].impreMatriz();
        System.out.println("Camino");
        floyd[1].recuperaCamino(4, 1);
        System.out.println();*/
        System.out.println("\n=== DIJKSTRA ===");
        
        // Probar desde varios orígenes
        int[] orígenes = {0, 2, 3};
        
        for (int origen : orígenes) {
            System.out.println("\nDijkstra desde vértice " + origen + ":");
            int[][] resultados = g.algoritmoDijkstra(origen);
            
            // Mostrar tabla simple
            for (int i = 0; i < resultados.length; i++) {
                String distancia;
                if (resultados[i][0] == Integer.MAX_VALUE - 1000) {
                    distancia = "INF";
                } else {
                    distancia = String.valueOf(resultados[i][0]);
                }
                
                System.out.println("A " + i + ": distancia=" + distancia + 
                                 ", predecesor=" + resultados[i][1]);
            }
        }
    } 
}
