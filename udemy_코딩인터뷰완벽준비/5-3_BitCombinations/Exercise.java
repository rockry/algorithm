import java.util.ArrayList;

public class Exercise {
    public static ArrayList<String> bitCombinations(int n) {
        // ToDo
        ArrayList<String> al = new ArrayList<>();
        return bitCombRec(al, "", n);
    }
    
    private static ArrayList<String> bitCombRec(ArrayList<String> al, String str, int n) { // 재귀호출 헬퍼함수는 private으로.
        if(n == str.length()) {
            al.add(str);
            return al;
        }
        bitCombRec(al, str+"0", n);
        bitCombRec(al, str+"1", n);
        return al;
    }
}