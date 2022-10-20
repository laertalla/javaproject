package extra;

public class Example2 {

	
	/**
	 *	nderto nje metode qe kontrollon nqs nje string 
	 *	permban me shume karaktere lowercasse sesa
	 *	 karakter uppercase 
	 **/
	
	public static boolean strChar(String s) {
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLowerCase(s.charAt(i))) {
				cnt1++;
			}
			else if(Character.isUpperCase(s.charAt(i))){
				cnt2++;
			}
		}
//		if(cnt1 > cnt2) {
//			return true;
//		}
//		return false;
		return cnt1 > cnt2;
	}
	
	public static void main(String[] args) {
		
		String s = "OTR";
		
		System.out.println(strChar(s));
	}
	
	
	
}
