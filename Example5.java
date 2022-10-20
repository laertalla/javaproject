package extra;

public class Example5 {
	
	/***
	 *	Nderto nje metode qe merr si paramter
	 *	nje varargs te tipit char dhe kthen
	 *	permbajtjen e tij ne nje string. 
	 **/

	public static String varargToString (char ... c) {
		String res = "";
		for (int i = 0; i < c.length; i++) {
			res += c[i];
		}
		return res;
	}
	
	public static void main(String[] args) {

		String s1 = varargToString();
		String s2 = varargToString('a');
		String s3 = varargToString('a', 'b');
		
		System.out.println(s1 + " " + s2 + " " + s3 + " ");
		
	}
	
}
