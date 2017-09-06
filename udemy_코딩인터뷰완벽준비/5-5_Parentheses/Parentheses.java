import java.util.List;
import java.util.ArrayList;

public class Parentheses {
	public static List<String> getPairs(int n) {
		List<String> result = pairRec(n, n, n, "", new ArrayList<String>()); /* 1. 헬퍼 함수에 필요한 인자를 생각해보기
		* n : 기존 인자 그대로 -> n은 사용안하므로 빼도 됨..
		* n : n개의 왼쪽 괄호 갯수
		* n : n개의 오른쪽 괄호 갯수
		* "" : 괄호를 채워갈 String 변수
		* ArrayList<String> : 결과를 누적할 List
		*/
		return result;
	}
	
	private static List<String> pairRec(int n, int left, int right, String pair, ArrayList<String> result) {
		if(left == 0 && right == 0) { // 6. 왼쪽 오른쪽 괄호를 모두 사용했을 경우
			result.add(pair);		// 7. 완성된 pair를 result에 add하고
			return result;			// 8.result를 return
			//(이 return은 pairRec함수가 return 구문이 있기때문에 return이 필요한 것이고 실제로 return 값을 사용하진 않음.) 
			//(java에서 객체는 call by reference 이므로 값은 공유메모리에 저장됨.)
		}
		
		if(left > 0) { // 5. left가 0이면 왼쪽괄호를 넣을 수 없음.
			pairRec(n, left-1, right, pair+"(", result); // 3. 왼쪽 괄호 일때, left를 1감소, pair에 "("추가, 다시 recursive 돌리기
		}
		
		if(left < right) { // 6. 왼쪽괄호가 이미 사용된 상태여야 오른쪽 괄호를 사용할 수 있음.
			pairRec(n, left, right-1, pair+")", result); // 4. 오른쪽 괄호 일때, right를 1감소, pair에 ")"추가, 다시 recursive 돌리기
		}
		
		return result;	// 2. 최종적으로 return할 결과
	}
	
	public static List<String> getPairs2(int n) {
		char[] pair = new char[2*n];
		List<String> result = pairRec2(n, n, pair, new ArrayList<String>()); /* 1. 헬퍼 함수에 필요한 인자를 생각해보기
		* n : 기존 인자 그대로 -> n은 사용안하므로 빼도 됨..
		* n : n개의 왼쪽 괄호 갯수
		* n : n개의 오른쪽 괄호 갯수
		* "" : 괄호를 채워갈 String 변수
		* ArrayList<String> : 결과를 누적할 List
		*/
		return result;
	}
	private static List<String> pairRec2(int left, int right, char[] pair, ArrayList<String> result) { //recursive 할때마다 매번 String을 새로 생성하기때문에 메모리 낭비가 심함.
		if(left < 0 || right < 0) {																	   //미리 char배열을 만들어 놓고 사용.
			return result;
		}
		if(left > right) {
			return result;
		}
		if(left == 0 && right == 0) {
			result.add(new String(pair));		
			return result;			
		}
		
		pair[pair.length - left - right]='(';
		pairRec2(left-1, right, pair, result);
		pair[pair.length - left - right]=')';
		pairRec2(left, right-1, pair, result);
		
		return result;
	}
	
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("Please input integer number for brace.");
			return;
		}
		System.out.println(Parentheses.getPairs(Integer.parseInt(args[0])).toString());
		System.out.println(Parentheses.getPairs2(Integer.parseInt(args[0])).toString());
	}
}