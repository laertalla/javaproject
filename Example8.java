package extra;

public class Example8 {

	/***
	 *	Nderto nje metode qe kontrollon nese nje string
	 *	permban karaktere qe formojne shkronja dyshe,
	 *	qe jane:
	 *
	 *		dh
	 *		gj
	 *		ll
	 *		nj
	 *		rr
	 *		sh
	 *		th
	 *		xh
	 *		zh
	 **/
	
	
	public static boolean containsDouble(String str) {
		for(int i = 0; i < str.length() - 1; i++) {
			if(isDoubleChar(str.substring(i, i + 2))) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isDoubleChar(String s) {
		if(s.length() != 2) {
			return false;
		}
		String[] doubleStr = {"dh", "gj", "nj", "ll", 
							  "rr", "sh", "th", "xh", 
							  "zh"};
		for(String e : doubleStr) {
			if(e.equalsIgnoreCase(s)) {
				return true;
			}
		}		
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(containsDouble("cfarre te dua une"));
		
	}
	
	
}




