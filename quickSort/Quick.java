public class Quick {
    public void sort(int[] arr, int left, int right){
        int i = left;
        int j = right;
        int pivot = arr[(left + right) / 2];
        
        do{
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j--;
            if(i <= j){    
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }while (i <= j);
        
        if(left < j) sort(arr, left, j);
        if(right > i) sort(arr, i, right);
    }
    
    public static void main(String[] args) {
        int data[] = {66, 10, 1, 34, 5, -10};
        
        Quick quick = new Quick();
        quick.sort(data, 0, data.length - 1);
        for(int i=0; i<data.length; i++){
            System.out.println("data["+i+"] : "+data[i]);
        }
    }
}
