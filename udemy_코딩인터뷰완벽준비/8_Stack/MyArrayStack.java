public class MyArrayStack {
	private int[] data = new int[100];
	private int topIndex = -1;
		
	public void push(int i) {
	    if(topIndex == data.length - 1) {
	        int[] new_data = new int[data.length * 2];
	        System.arraycopy(data, 0, new_data, 0, data.length);
	        data = new_data;
	    }
	    data[++topIndex] = i;
	}
	
	public int pop() {
	    if(topIndex < 0) {
	        throw new RuntimeException("Nothing to pop");
	    }
	    return data[topIndex--];
	}
}
