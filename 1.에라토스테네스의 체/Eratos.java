import java.util.Scanner;

public class Eratos {
    public static void main(String[] args) {
        int num = 100;

//        if (args.length > 0)
//            num = Integer.parseInt(args[0]);

        System.out.print("input a number : ");
        Scanner scn = new Scanner(System.in);
        num = scn.nextInt();
        //num = System.in.read();

        long start = System.currentTimeMillis();
        getEratos(num);
        long end = System.currentTimeMillis();
        System.out.println( "<elapsed time> : " + ( end - start )/1000.0 ); 
    }

    public static void getEratos(int max) {
        boolean[] a = new boolean[max];

        for (int i = 2; i < max; i++) 
            a[i] = true;
            
        int to = (int)Math.sqrt(max);
        
        for (int i = 2; i < to; i++)
            if (a[i] != false)

        for (int j = i; j*i < max; j++) 
            a[i*j] = false;
                    
        for (int i = 2; i < max; i++)
            if (a[i]) 
                System.out.print(" " + i);

        System.out.println();
    }

}
