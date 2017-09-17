class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        int[] result = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > arr.length || arr[i] < 1) {
                return false;
            }
            if(result[arr[i]] != 0) {
                return false;
            }
            result[arr[i]] = 1;
        }
        return answer;
    }
}

class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > arr.length || arr[i] < 1) {
                return false;
            }
            swap(arr, i, arr[i]-1);
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i]-1 != i) {
                return false;
            }
        }
        return answer;
    }
    private void swap(int[]arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}