package extra;

public class Example6 {

	/***
	 *	Nderto nje metode qe merr si parameter nje numer
	 *	te plote n dhe printon ne format tabele prodhimin
	 *	e ketij numri me 10 numrat e pare natyrore.
	 *
	 * 	Psh
	 * 
	 * 			input		10
	 * 
	 * 			10 * 1 = 10
	 * 			10 * 2 = 20
	 * 			...
	 * 			10 * 10 = 100
	 **/
	
	public static void print(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
		}
	}
	
	public static void main(String[] args) {	
		
		System.out.println("Vendosn nje numer:");
		int a = extra.Util.input.nextInt();
		print(a);
		
	}
	
}
