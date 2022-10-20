package extra;

public class Example4 {

	/**
	 *	Nderto metoden qe gjen shumen e vlerave cift
	 *	te nje vektori me numra te plote. 
	 **/
	
	public static int sumEvenElements(int[] array) {
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] % 2 == 0) {
				sum += array[i];
			}
		}
		return sum;		
	}
	
	public static void main(String[] args) {
		int a[] = {10, 7, 4, 31, -19};
		System.out.println(sumEvenElements(a));
	}
	
}
