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
            next = node.next;   // 다음 node를 미리 load
            node.next = prev;   // node.next에 이전 node를 attach
            prev = node;        // prev에 현재 노드를 대입
            node = next;        // node = 다음 노드
        }                       // 1 - (2) - 3 => next = 3, node.next = 1, prev = 2(next는 1), node = 3
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
    
    public boolean isPalindrome() {
        Node n1 = head;
        Node n2 = head;
        Stack<Integer> stack = new Stack<>();
        
        while (n2 != null && n2.next != null) {
            stack.push(n1.data);
            n1 = n1.next;
            n2 = n2.next.next;
        }
        
        // n2가 not null이면 홀수라는 의미 => 중간값을 skip
        if (n2 != null) {
            n1 = n1.next;
        }
        
        while (n1 != null) {
            if (stack.pop() != n1.data) {
                return false;
            } else {
                n1 = n1.next;
            }
        }
        return true;
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
