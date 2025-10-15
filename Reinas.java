package APANLOO;
public class Reinas
{
    static int numsol = 1; 
    public static void main(String[] args) 
    {
        int n = 8; 
        int[] reinas = new int[n]; 
        coloca(0, reinas);
    }
    public static boolean seMatan(int r1, int c1, int r2, int c2)
    {
        if(r1==r2 || c1==c2)
        {
            return true;
        }
        return Math.abs(r1-r2) == Math.abs(c2-c1);
    }
    public static boolean posibilidad(int[]reinas, int n, int c)
    {
        for(int i=0 ;i<n; i++ )
        {
            if(seMatan(i,reinas[i],n,c))
            {
                return true;
            }
        }
        return false;
    }
    public static void pintaTablero(int numsol,int [] reinas)
    {
        System.out.println("solucion num: " +numsol);
        for(int i=0; i<reinas.length; i++)
        {
            for(int j=0; j<reinas.length; j++)
            {
                if(reinas[i]==j)
                {
                    System.out.print("X ");
                }
                else
                {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void coloca(int n, int [] reinas )
    {
        if(n==reinas.length)
        {
            pintaTablero(numsol, reinas);
            numsol++;
            return;
        }
        for(int i=0; i<reinas.length; i++)
        {
            if(!posibilidad(reinas,n,i))
            {
                reinas[n]=i;
                coloca(n+1,reinas);
            }
        }
    } 
}