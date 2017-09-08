import java.util.ArrayList;
import java.util.List;

public class MyListStack<T> {
	
	private List<T> list;
	
	public MyListStack() {
		list = new ArrayList<>();
	}
	
	public void push(T i) {
		list.add(i);
	}
	
	public T pop() {
		return list.remove(list.size()-1);
	}
}
