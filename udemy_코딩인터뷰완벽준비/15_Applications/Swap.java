public class Swap {
    public static void swap(int i, int k, int[] a) {
        // a[i] = 3, a[k] = 10
        a[i] = a[k] - a[i]; // 10 - 3, a[i] = 7 
        a[k] = a[k] - a[i]; // 10 - 7, a[k] = 3
        a[i] = a[k] + a[i]; //  3 + 7, a[i] = 10
    }
    public static void swap2(int i, int k, int[] a) {
        // a[i] = 0011, a[k] = 1010
        a[i] = a[i] ^ a[k]; // 0011 ^ 1010, a[i] = 1001     // a[i] = 3 ^ 10, a[k] = 10
        a[k] = a[k] ^ a[i]; // 1010 ^ 1001, a[k] = 0011     // a[i] = 3 ^ 10, a[k] = 10 ^ 3 ^ 10 = 3
        a[i] = a[i] ^ a[k]; // 1001 ^ 0011, a[i] = 1010     // a[i] = 3 ^ 10 ^ 3 = 10
    }
}