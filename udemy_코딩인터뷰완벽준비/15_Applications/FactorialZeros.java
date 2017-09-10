public class FactorialZeros {
    public static int count(int n) {
        int count = 0;
        
        for(int i = 5; i <= n; i += 5) {
            int num = i;
            while(num % 5 == 0) {
                num /= 5;
                count++;
            }
        }
        
        return count;
    }
}