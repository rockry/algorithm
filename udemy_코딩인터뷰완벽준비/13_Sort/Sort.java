public class Sort {
    public static void BubbleSort(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 0; j < a.length - 1 - i; j++) {
                if(a[j] > a[j+1]) {
                    swap(a, j, j+1);
                }
            }
        }
    }
    private static void swap(int[] a, int x, int y) {
        int temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void AgeSort(int[] a) {
        int[] indexArr = new int[150];
        for(int p:a) {
            indexArr[p]++;
        }
        int index = 0;
        for(int i = 0; i < indexArr.length; i++) {
            while(indexArr[i]-- != 0) {
                a[index++] = i;
            }
        }
    }
}