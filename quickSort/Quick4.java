public class Quick4 {
	public void printArray(int[] arr, int i, int j, int left, int right, int pivot) {
		for(int n = 0; n < arr.length; n++) {
			if(n == left) System.out.print("(");
            if(n == i && n == j) {
                System.out.print("*");
            } else if(n == i) {
                System.out.print("i");
            } else if(n == j) {
                System.out.print("j");
            }
            System.out.print(arr[n] + " ");
			if(n == right) System.out.print(")");
		}
		System.out.println(" pivot = " + pivot);
    }
    
    public void quick_hoare(int[] arr, int left, int right) {
        if(left < right) {
            int i = left + 1;
            int j = right;
            int pivot = arr[left];
            while(i < j) {
                while(i < right && pivot >= arr[i]) i++;
                while(pivot < arr[j]) j--;
                
                if(i < j) {
                    printArray(arr, i, j, left, right, pivot);
                    swap(arr, i, j);
                    printArray(arr, i, j, left, right, pivot);
                }
            }
            printArray(arr, i, j, left, right, pivot);
            if(arr[left] > arr[j])
                swap(arr, left, j);
            printArray(arr, i, j, left, right, pivot);
            
            quick_hoare(arr, left, j - 1);
            quick_hoare(arr, j + 1, right);
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        //int data[] = {66, 10, 1, 34, 5, -10, 8, 9};
		// int data[] = {9,3,8,5,2,1,6,4};
        int data[] = {3,4,9};
        
        Quick4 quick = new Quick4();
        quick.quick_hoare(data, 0, data.length - 1);
        for(int i=0; i<data.length; i++){
            System.out.println("data["+i+"] : "+data[i]);
        }
    }
}
