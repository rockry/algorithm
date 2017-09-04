import java.util.List;
import java.util.ArrayList;

public class Permutation {
	public static List<String> getPermutations2(String s) {
		return permRec2(s, new boolean[s.length()], "", new ArrayList<String>());
	}
	
	private static List<String> permRec2(String s, boolean[] pick, String perm, List<String> result) {
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
	    int n = cl.length;
	    if(i == n -1) {
	        result.add(new String(cl));
	        return result;
	    } else {
	        for(int j = i; j < n; j++) {
	            char temp;
	            temp = cl[i];
	            cl[i] = cl[j];
	            cl[j] = temp;
	            permRec(cl, i + 1, result);
	            temp = cl[i];
	            cl[i] = cl[j];
	            cl[j] = temp;	            
	        }
	    }
	    return result;
	}
}
