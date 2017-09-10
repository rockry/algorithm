public class BinaryTreeHandler {
    public static int getMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        int leftMax = getMax(root.left);
        int rightMax = getMax(root.right);
        int childMax = Math.max(leftMax, rightMax);
        return Math.max(childMax, root.data);
    }

    public static boolean isBalanced(Node root) {
        return isBalancedHelper(root) != -1;
    }
    
    private static int isBalancedHelper(Node n) {
        if (n == null) {
            return 0;
        }
        
        int l = isBalancedHelper(n.left);
        if (l == -1) {
            return -1;
        }
        
        int r = isBalancedHelper(n.right);
        if (r == -1) {
            return -1;
        }
        
        int diff = Math.abs(r - l);
        
        if (diff > 1) {
            return -1;
        }
        
        return Math.max(l, r) + 1;
    }

    public static Node build(int[] a) {
        return buildRec(a, 0, a.length-1);
    }
    
    private static Node buildRec(int[] a, int l, int h) {
        if(l > h) {
            return null;
        }
        int m = (l+h)/2;
        
        Node left = buildRec(a, l, m-1);
        Node right = buildRec(a, m+1, h);
        int leftVal = left!=null?left.data:-1;
        int rightVal = right!=null?right.data:-1;
        System.out.println("<build>" + a[m] + ", " + leftVal + ", " + rightVal);
        return new Node(a[m], left, right);
    }

    public static boolean isBst(Node root) {
        // ToDo
        return isBstRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private static boolean isBstRec(Node node, int min, int max) {
        if(node == null) {
            return true;
        }
        
        System.out.println("<isBst>" + node.data + ", " + min + ", " + max);
        if(node.data <= min || node.data > max) {
            return false;
        }
        
        boolean leftBst = isBstRec(node.left, min, node.data);
        boolean rightBst = isBstRec(node.right, node.data, max);
        
        return leftBst && rightBst;
    }

    public static void main(String[] args) {
        Node root = BinaryTreeHandler.build(new int[]{1,2,3,4,5,6,7,8});
        // System.out.println(BinaryTreeHandler.getMax(root));
        System.out.println(BinaryTreeHandler.isBst(root));
    }
}