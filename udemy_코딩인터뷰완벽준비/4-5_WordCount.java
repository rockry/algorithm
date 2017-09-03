import java.util.HashMap;

public class WordCount {
    private HashMap<String, Integer> map;
    
    public WordCount(){
        map = new HashMap<>();
    }
    
    public void read(String[] doc) {
        for(String word:doc) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
    }
    
    public int getCount(String word) {
        if(map.containsKey(word)) {
            return map.get(word);
        }
        return 0;
    }
}