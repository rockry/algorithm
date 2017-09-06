public class Fibonacci {
    public static int fibonacci(int n) {
        // Recursive (no dynamic programming)
        if (n <= 1) {
            return n;
        }
        
        return fibonacci(n-1) + fibonacci(n-2);
    }
    
    public static int fibonacciFaster(int n) {
        //Dynamic Programming
        int[] memo = new int[n+1]; // java는 int 배열 생성시 0으로 자동 초기화

        return fibonacciFaster(n, memo);
    }
    private static int fibonacciFaster(int n, int[] memo) {
        if(n <= 1) {
            return n;
        }
        if(memo[n]>0) {
            return memo[n];
        }
        // memo[n-1] = fibonacciFaster(n-1, memo);
        // memo[n-2] = fibonacciFaster(n-2, memo);
        // return memo[n-1] + memo[n-2];

        memo[n] = fibonacciFaster(n-1, memo) + fibonacciFaster(n-2, memo);
        return memo[n];
    }
    public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Please input integer number for brace.");
			return;
		}
        long start = System.currentTimeMillis();
        System.out.println(Fibonacci.fibonacci(Integer.parseInt(args[0])));
        long end = System.currentTimeMillis();
        System.out.println( "<elapsed time> : " + ( end - start )/1000.0 ); 

        long start2 = System.currentTimeMillis();
        System.out.println(Fibonacci.fibonacciFaster(Integer.parseInt(args[0])));
        long end2 = System.currentTimeMillis();
        System.out.println( "<elapsed time> : " + ( end2 - start2 )/1000.0 ); 		
		
	}
}