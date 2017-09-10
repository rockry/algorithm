public class Quick3 {
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
	public void sort(int[] arr, int left, int right) {
		int i = left, j = right;
		int pivot = arr[(left + right) / 2];
		int temp;
		while (i<= j) { //왼쪽과 오른쪽이 역전될때까지
			while (arr[i] < pivot) i++; // 왼쪽에서 pivot보다 큰 수를 만날때까지
			while (arr[j] > pivot) j--; // 오른쪽에서 pivot보다 작은 수를 만날때까지
			if (i<= j) {
				printArray(arr, i, j, left, right, pivot);
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				printArray(arr, i, j, left, right, pivot);
				i++;
				j--;
			}
		}
		printArray(arr, i, j, left, right, pivot);
		/* recursion(Divide) */
		if (left < j)
			sort(arr, left, j);
	
		if (i < right)
			sort(arr, i, right);
	}
    
    public static void main(String[] args) {
        //int data[] = {66, 10, 1, 34, 5, -10, 8, 9};
		int data[] = {9,3,8,5,2,1,6,11,4};
        
        Quick3 quick = new Quick3();
        quick.sort(data, 0, data.length - 1);
        for(int i=0; i<data.length; i++){
            System.out.println("data["+i+"] : "+data[i]);
        }
    }
}
