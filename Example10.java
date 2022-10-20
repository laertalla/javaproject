package extra;

import java.util.Arrays;

public class Example10 {

	/***
	 *	Nderto nje metode qe merr si parameter
	 *	nje matrice me vektore te tipit char
	 *	dhe jep si rezultat vektorin qe ka shumen e
	 *	karaktereve vleren me te madhe. 
	 **/
	
	public static int vecSum (char[] v) {
		int sum = 0;
		for (int i = 0; i < v.length; i++) {
			sum += v[i];
		}
		
		return sum;
	}
	
	public static char[] charsWithMaxSum(char[][] a) {
		int max = vecSum(a[0]);
		int index = 0;
		for (int i = 1; i < a.length; i++) {
			int sum = vecSum(a[i]);
			if (sum > max) {
				max = sum;
				index = i;
			}
		}
		return a[index];
	}
	
	public static void main(String[] args) {

		System.out.println
			(Arrays.toString(charsWithMaxSum(new char[][] {
				{'o', 't', 'r'},
				{'t', 'b', 'a'},
				{'h', 'e' , 'l', 'l',},
				{},
				{},
			})));
		
	}
	
}










