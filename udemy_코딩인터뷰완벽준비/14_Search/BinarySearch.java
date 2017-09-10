public class BinarySearch {
    public static int search(int[] data, int target) {
        if(data == null) {
            return -1;
        }
        for(int i = 0,j = data.length-1; i <= j;) {
            int m = (i + j) / 2;
            if(data[m] == target) {
                return m;
            } else if(data[m] > target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return -1;
        
        return searchRec(data, target, 0, data.length - 1); //length - 1!!
	}
	private static int searchRec(int[]  data, int target, int start, int end) {
	    if(start > end || start < 0 || end >= data.length) {
	        return -1;
	    }
	    
	    int m = (start + end) / 2;
        if(data[m] == target) {
            return m;
        } else if(data[m] > target) {
            return searchRec(data, target, start, m-1);
        } else {
            return searchRec(data, target, m+1, end);
        }
	}
}