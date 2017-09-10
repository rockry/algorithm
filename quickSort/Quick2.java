public class Quick2 {
	public void sort(int[] arr, int left, int right) {
		int i, j, pivot, temp;
		
		if (left < right) {
			i = left;
			j = right;
			pivot = arr[left];
			
			while (i < j) {
				while (arr[j] > pivot) j--;
				// 이 부분에서 arr[j-1]에 접근해서 익셉션 발생가능함.
				// pivot을 left에서 고르면 회피가능.
				while (i < j && arr[i] <= pivot) i++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			arr[left] = arr[i];
			arr[i] = pivot;
			/* recursion(Divide) */
			sort(arr, left, i - 1);
			sort(arr, i + 1, right);
		}
	}
	
	public static void main(String[] args) {
		int data[] = {5,7,8,9,1,2,6};
		
		Quick2 quick = new Quick2();
		quick.sort(data, 0, data.length - 1);
		for(int i=0; i<data.length; i++){
			System.out.println("data["+i+"] : "+data[i]);
		}
	}
}
