class BinarySearchTree {
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
    
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = array[mid];
    
            //찾고자 하는 값이 중간요소 보다 큰경우
            if (midVal < key)
                low = mid + 1;
            //찾고자 하는 값이 중간요소 보다 작은경우
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1); // key not found.
    }
 
    //재귀호출 스타일
    public static int binarySearch2(int[] array, int fromIndex, int toIndex, int key) {
        
        if (toIndex < fromIndex)
            return -1; // key not found.
        
        int mid = (toIndex+fromIndex) >>> 1;
    
        //찾고자 하는 값이 중간요소 보다 작은경우
        if (array[mid] > key)
            return binarySearch2(array, fromIndex, mid-1, key);
        //찾고자 하는 값이 중간요소 보다 큰경우
        else if (array[mid] < key)
            return binarySearch2(array, mid+1, toIndex, key);
        else
            return mid; // key found
    }

    // public static int binarySearch3(int[] array, int key) {
    //     int index = array.length/2;
    //     int prev = index;
    //     while(index > -1 && index < array.length-1) {
    //         if(array[index] == key) {
    //             return index;
    //         } else if(array[index] < key) {
    //             prev = index;
    //             index = index + 
    //         }
    //     }
    // }

    public static void main(String args[]) {
        int[] array = {1,3,4,5,8,11,15,17,18,22,25,36,38,45,88};
        int index = binarySearch(array, 7);
        System.out.println("index=" + index + ", value=" + array[index]);
        int index2 = binarySearch2(array, 0, array.length, 7);
        System.out.println("index2=" + index2 + ", value2=" + array[index]);
    }
}


