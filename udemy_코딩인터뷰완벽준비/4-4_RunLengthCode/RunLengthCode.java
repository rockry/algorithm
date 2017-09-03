public class RunLengthCode {
    public static String coding(String s) {
        char[] ca = s.toCharArray();
        char saved = ca[0];
        int num = 1;
        String result = "";
        for(int i = 1; i < ca.length; i++) {
            if(saved == ca[i]) {
                num++;
            } else {
                result += saved + String.valueOf(num);
                num = 1;
                saved = ca[i];
            }
        }
		return result += saved + String.valueOf(num);
	}
}