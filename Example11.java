package extra;

import java.util.ArrayList;

public class Example11 {

	/***
	 *	Krijo nje metode qe merr si parameter
	 *	nje string dhe jep si rezultat listen
	 *	qe ruan karakteret e tij pa perseritje. 
	 **/
	
	public static ArrayList<Character> list(String s){
		ArrayList<Character> l = new ArrayList<Character>();
		for(int i = 0; i < s.length(); i++) {
			if(!l.contains(s.charAt(i))) {
				l.add(s.charAt(i));
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		System.out.println(list("Ouagadougou"));
	}
	
}










