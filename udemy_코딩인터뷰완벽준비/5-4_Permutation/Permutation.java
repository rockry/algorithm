import java.util.List;
import java.util.ArrayList;

public class Permutation {
    static int count1 = 0;
    static int count2 = 0;
	public static List<String> getPermutations2(String s) {
		return permRec2(s, new boolean[s.length()], "", new ArrayList<String>());
	}
	
	private static List<String> permRec2(String s, boolean[] pick, String perm, List<String> result) {
        System.out.println("count1="+ count1++);
	    if(perm.length() == s.length()) {
	        result.add(perm);
	        return result;
	    }
	    
	    for(int i =0; i < s.length(); i++) {
	        if(pick[i]) {
	            continue;
	        }
	        pick[i] = true;
	        permRec2(s, pick, perm+s.charAt(i), result);
	        pick[i] = false;
	    }
	    return result;
	}
	
	public static List<String> getPermutations(String s) {
	    char[] charList = s.toCharArray();
	    return permRec(charList, 0, new ArrayList<String>());
	}
	private static List<String> permRec(char[] cl, int i, List<String> result) {
        System.out.println("count2=" + count2++);
	    int n = cl.length;
	    if(i == n -1) {
	        result.add(new String(cl));
	        return result;
	    } else {
	        for(int j = i; j < n; j++) {
	            swap(cl, i, j);
	            permRec(cl, i + 1, result);
                swap(cl, i, j);
	        }
	    }
	    return result;
	}
    private static void swap(char[] cl, int i, int j) {
        char temp;
        temp = cl[i];
        cl[i] = cl[j];
        cl[j] = temp;
    }
    
    public static void main(String[] args) {
        System.out.println(Permutation.getPermutations2("abc").toString());
        System.out.println(Permutation.getPermutations("abc").toString());
    }
}
