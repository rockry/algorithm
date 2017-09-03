import java.util.HashMap;

public class Anagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            if (hashmap.containsKey(c)) {
                hashmap.put(c, hashmap.get(c) + 1);
            } else {
                hashmap.put(c, 1);    
            }
        }
        
        for (char c : s2.toCharArray()) {
            if (hashmap.containsKey(c) == false) {
                return false;
            }
            
            if (hashmap.get(c) <= 0) {
                return false;
            }
            
            hashmap.put(c, hashmap.get(c) - 1);
        }
        
        return true;
    }
}