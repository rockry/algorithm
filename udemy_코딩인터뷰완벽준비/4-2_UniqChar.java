import java.util.HashSet;

public class UniqChar {
    public static boolean isUniqChar(String s) {
        HashSet<Character> hs = new HashSet<>();
        char[] ca = s.toCharArray();
        for(char c:ca) {
            if(!hs.contains(c)) {
                hs.add(c);
            } else {
                return false;
            }
        }
        return true;
    }
}