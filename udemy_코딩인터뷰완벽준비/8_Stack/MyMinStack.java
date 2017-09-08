import java.util.Stack;

public class MyMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
	
	public MyMinStack() {
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	
	public void push(int newVal) {
	    if (minStack.isEmpty() || minStack.peek() >= newVal) {
	        minStack.push(newVal);
	    }
	    stack.push(newVal);
	}
	
	public int pop() {
		int val = stack.pop();
		if (!minStack.isEmpty() && val == minStack.peek()) {
		    minStack.pop();
		}
		return val;
	}
	
	public int min() {
        if(minStack.isEmpty()) {
            return Integer.MAX_VALUE; //-1>>>1 로도 가능. -1은 111111111111111111111111 이고 >>> 하면 011111111111111111111111 이됨.
        }
	    return minStack.peek();
	}

    public static void main(String[] args) {
        MyMinStack myStack = new MyMinStack();

        myStack.push(1);

        System.out.println(myStack.min());
        System.out.println(myStack.pop());
        System.out.println(myStack.min());
    }
}