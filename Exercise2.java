package lessontwo;

public class Exercise2 {
	
	public static void main(String[] args) {
		
		Integer n = new Integer(10);
		
		boolean condition = n.isOdd();
		System.out.println(condition);
		
		condition = n.isEven();
		System.out.println(condition);
		
		condition = n.isPrime();
		System.out.println(condition);

		if(n.isOdd()) {
			System.out.println("Is odd number");
		}
		
		if(n.isEven()) {
			System.out.println("Is even number");
		}
		
		if(n.isPrime()) {
			System.out.println("Is prime number");
		}


		if(Integer.isOdd(10)) {
			System.out.println("Is odd number");
		}
		
		if(Integer.isEven(10)) {
			System.out.println("Is even number");
		}
		
		if(Integer.isPrime(10)) {
			System.out.println("Is prime number");
		}


		if(Integer.isOdd(new Integer(27))) {
			System.out.println("Is odd number");
		}
		
		if(Integer.isEven(n)) {
			System.out.println("Is even number");
		}
		
		if(Integer.isPrime(n)) {
			System.out.println("Is prime number");
		}
		
		System.out.println(Integer.convert(new char[] { '-', '1', '0', '7', '4', '3', '1', '1', '9' }).getValue());
		System.out.println(Integer.convert("+10743119").getValue());
		
	}

}
