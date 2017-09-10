public class BitOperator {
    public static boolean get(int n, int i) {
        return (1<<i & n) != 0;
    }
    
    public static int set(int n, int i) {
        return 1<<i | n;
    }
    
    public static int clear(int n, int i) {
        return ~(1<<i) & n;
    }
    
    public static boolean isPowerOf2(int n) {
		return (n & (n-1)) == 0;
    }
    
    public static int bitDiffCounter(int a, int b) {
        int diff = a^b;
        int count = 0;
        while(diff != 0) {
            /* 11100 & 11011 = 11000
            *  11000 & 10111 = 10000
            *  10000 & 01111 = 0
            */
            diff = diff & (diff-1);
            count++;
        }
        return count;
    }
}