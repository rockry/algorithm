public class Quick5 {
    int partition(int arr[], int left, int right) {
          int i = left, j = right;
          int pivot = arr[(left + right) / 2];
          int tmp;
          
          while (i <= j) {
                while (arr[i] < pivot) i++;
                while (arr[j] > pivot) j--;
                if (i <= j) {
                      printArray(arr, i, j, left, right, pivot);
                      tmp = arr[i];
                      arr[i] = arr[j];
                      arr[j] = tmp;
                      i++;
                      j--;
                      printArray(arr, i, j, left, right, pivot);
                }
          };
         
          return i;
    }
     
    void quickSort(int arr[], int left, int right) {
          int index = partition(arr, left, right);
          if (left < index - 1)
                quickSort(arr, left, index - 1);
          if (index < right)
                quickSort(arr, index, right);
    }

    public static void main(String[] args) {
        // int data[] = {66, 10, 1, 34, 5, -10, 8, 9};
		// int data[] = {9,3,8,5,2,1,6,4};
        // int data[] = {3,4,9};
      //   int data[] = {9,4,3};
      int data[] = {2,9,3,8,7,6,5,13,1,11};
        
        Quick5 quick = new Quick5();
        quick.quickSort(data, 0, data.length - 1);
        for(int i=0; i<data.length; i++){
            System.out.println("data["+i+"] : "+data[i]);
        }
    }

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
}
