package extra;

import java.util.Arrays;

public class Example9 {

	/***
	 *	Krijo nje metode qe merr si parameter 3 vektore
	 *	te tipit char dhe krijon me to nje matrice. 
	 **/
	
	public static char[][] chars(char[] c1, 
								 char[] c2, 
								 char[] c3){
		return new char[][] {
			c1, c2, c3
		}; 
	}
	
	public static void main(String[] args) {
		
		char[] c = new char[]{'o', 't', 'r'};
		
		char[][] chars1 = chars(c,
								new char[]{'t', 'b', 'a'},
								new char[]{'o', 'j', 'f'});
		
		chars1[0][0] = 'O';
		c[0] = 'O';
		
		for(char[] a : chars1) {
			System.out.println(Arrays.toString(a));
		}
		
	}

}

