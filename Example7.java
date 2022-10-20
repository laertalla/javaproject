package extra;

public class Example7 {

	/***
	 *	Nderto nje metode qe merr si parameter
	 *	nje vektor me karaktere dhe nje string.
	 *	Metoda kontrollon nese stringu gjendet
	 *	ne permbajtjen e vektorit.
	 *
	 *	Psh
	 *
	 *		['o', 't', 'r']					"otr"		true
	 *		['o', 't', 'r', 'o']			"otr"		true
	 *		['o', 'o', 't', 'r', 'o']		"otr"		true
	 *		['o', 'o', 't']					"otr"		false
	 *		
	 **/
	
	public static boolean turk(char[]a, String s) {
		if(a == null && s == null) {
			return true;
		}
		if(a == null) {
			return false;
		}
		if(s == null) {
			return true;
		}
		if(a.length < s.length()) {
			return false;
		}
		for(int i = 0; i < a.length - s.length() + 1; i++)
		{
			boolean equalChars = true;
			for(int j = 0; j < s.length(); j++) {
				if(a[i + j] != s.charAt(j)) {
					equalChars = false;
					break;
				}
			}
			if(equalChars) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

		System.out.println(turk(new char[] {'o', 't', 'r'}, 
								"otr"));

		System.out.println(turk(new char[] {'o', 'o', 't', 'r'}, 
								"otr"));

		System.out.println(turk(new char[] {'o', 'o', 'o'}, 
								"otr"));

		System.out.println(turk(new char[] {'o', 't', 'r', 'r'}, 
								"otr"));

		System.out.println(turk(new char[] {'o', 't', 'r'}, 
								null));

		System.out.println(turk(null, null));
		
	}
	
	
}
