import java.util.Queue;
import java.util.Stack;

public class ReverseQueue<T> {
    public Queue reverse(Queue<T> q){
        if(q == null) return null;
        Stack<T> stack = new Stack<>();
        while(!q.isEmpty()) {
            stack.push(q.poll());
        }
        while(!stack.isEmpty()) {
            q.offer(stack.pop());
        }
        return q;
    }
}