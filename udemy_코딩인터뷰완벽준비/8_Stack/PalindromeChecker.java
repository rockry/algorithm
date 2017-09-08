import java.util.Stack;

public class PalindromeChecker {
    
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<charArr.length/2; i++) {
            stack.push(charArr[i]);
        }
        
        for (int i=(charArr.length+1)/2; i<charArr.length; i++) {
            if (stack.pop() != charArr[i]) {
                return false;
            } 
        }
        
        return true;
        
    }

}