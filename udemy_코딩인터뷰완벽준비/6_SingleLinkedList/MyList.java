import java.util.HashSet;

public class MyList {
    private Node head;

    public void addToHead(int n) {
        Node newNode = new Node();
        newNode.data = n;
        newNode.next = head;
        head = newNode;
    }

    public void removeFirst() {
        if (head == null) {
            throw new RuntimeException("There is no node to remove");
        }
        
        head = head.next;
    }
    
    public void removeDuplicates() {
        Node node = head;
        Node prev = null;
        HashSet<Integer> hashset = new HashSet<>();
        
        while (node != null) {
            if (hashset.contains(node.data)) {
                prev.next = node.next;
            } else {
                hashset.add(node.data);
                prev = node;
            }
            node = node.next;
        }
    }

    public void badperf_reverse() {
        Node oldHead = head;
        head = null;
        
        for(Node n = oldHead; n != null; n=n.next) {
            addToHead(n.data);
        }
    }
    
    public void reverse() {
        Node node = head;
        Node prev = null;
        Node next = null;
        
        while(node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        head = prev;
    }

    
    public Node badperf_kthToLast(int k) {
        if(k < 0) {
            return null;
        } 
        int len = 0;
        Node node = head;
        while(node != null) {
            len++;
            node = node.next;
        }
        node = head;
        
        for(int i = 0; i < len - k - 1; i++) {
            node = node.next;
        }
        return node;
    }
    
    public Node kthToLast(int k) { //Runner 기법
        Node n1 = head;
        Node n2 = head;
        
        for (int i=0; i<k; i++) {
            if (n1.next != null) {
                n1 = n1.next;
            } else {
                return null;
            }
        }
        
        while (n1.next != null) {
            n2 = n2.next;
            n1 = n1.next;
        }
        
        return n2;
    }
 
    @Override
    public String toString() {
        String str = "[ ";
        for(Node n = head; n!=null; n=n.next) {
            str += n.data;
            str += " ";
        }
        str += "]";
        return str;
    }

    public static void main(String[] args) {
        MyList mylist = new MyList();
        for(int i = 0; i < 10; i++) {
            mylist.addToHead(i);
        }

        System.out.println(mylist.toString());
        System.out.println(mylist.kthToLast(2).data);
    }
}
