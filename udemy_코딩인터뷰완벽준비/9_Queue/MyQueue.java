import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stack1;
    Stack<T> stack2;
    
    public MyQueue() {
        stack1 = new Stack<T>();
        stack2 = new Stack<T>();
    }
    
    public void offer(T element) {
        stack1.push(element);
    }
    
    public T poll() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public T bad_poll() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        T res = stack2.pop();
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
    
    public int size() {
        return stack1.size() + stack2.size();
    }
}