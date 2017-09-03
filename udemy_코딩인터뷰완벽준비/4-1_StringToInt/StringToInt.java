public class StringToInt {
	public static int convert(String s) {
		int result = 0;
		
		for (int i=0; is.length(); i++) {
		    result = 10; 
		    result += s.charAt(i) - '0';
		}
		
		return result;
	}
}