package extra;

public class Example3 {
	
	/***
	 *		Nderto nje metode qe kthen se
	 *		prapthi permbajtjen e nje stringu
	 *		te dhene. 		
	 **/
	
	public static String reverseString(String s) {
		String result = "";
		for(int i = 0; i < s.length(); i++) {
			result += s.charAt(s.length() - i - 1);
 		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(reverseString("Ougadougu"));
	}
	
}
