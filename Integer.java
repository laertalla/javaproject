package lessontwo;

import extra.Util;

public class Integer {
	
	private final int value;

	public Integer(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isOdd() {
//		if(value % 2 != 0) {
//			return true;
//		}
//		return false;
//		return value % 2 != 0;
		return isOdd(value);
	}
	
	public boolean isEven() {
//		return value % 2 == 0;
//		return !isOdd();
		return isEven(value);
	}
	
	public boolean isPrime() {
//		if(value < 2) {
//			return false;
//		}
//		if (value == 2) {
//			return true;
//		}
//		if(isEven()) {
//			return false;
//		}
//		int divider = 3;
//		while(divider * divider <= value) {
//			if(value % divider == 0) {
//				return false;
//			}
//			divider += 2;
//		}
//		return true;
		return isPrime(value);
	}
	
	public static boolean isOdd(int value){
//		return new Integer (value).isOdd();
		return value % 2 != 0;
	}
	
	public static boolean isEven(int value) {
		return !isOdd(value);
	}
	
	public static boolean isPrime(int value){
		if(value < 2) {
			return false;
		}
		if (value == 2) {
			return true;
		}
		if(isEven(value)) {
			return false;
		}
		int divider = 3;
		while(divider * divider <= value) {
			if(value % divider == 0) {
				return false;
			}
			divider += 2;
		}
		return true;
	}
	
	public static boolean isOdd(Integer number) {
//		if(number == null) {
//			return false;
//		}
		return number != null ? number.isOdd() : false;
	}
	
	public static boolean isEven(Integer number) {
		return number != null ? number.isEven() : false;
	}
	
	public static boolean isPrime(Integer number) {
		return number != null ? number.isPrime() : false;
	}

	public static Integer convert(char[] a) {
		if(a == null || a.length == 0) {
			return null;
		}
		if(a.length == 1 && (a[0] == '+' || a[0] == '-')) {
			return new Integer(0);
		}
		StringBuilder s = new StringBuilder();
		int i = 0;
		if(a[0] == '+' || a[0] == '-') {
			s.append(a[0]);
			i = 1;
		}
		while(i < a.length) {
			if(Character.isDigit(a[i])) {
				s.append(a[i]);
			}
			i++;
		}
		if(s.charAt(0) == '-') {
			if(s.length() >= 11){
				//gjatesia e numrit negativ eshte me e madhe se gjatesia e numrit me t vogel int(11)
				while(Util.isSmallerThan(s.toString().toCharArray(), 
										 (java.lang.Integer.MIN_VALUE + "").toCharArray())) {
					s.deleteCharAt(s.length() - 1);
				}
			}
		}
		else {
			byte length = 10;
			if(s.charAt(0) == '+') {
				length = 11;
			}
			if(s.length() >= length) {
				while(Util.isGreaterThan(s.toString().toCharArray(), 
					  (java.lang.Integer.MIN_VALUE + "").toCharArray())) {
					s.deleteCharAt(s.length() - 1);
				}
			}
		}
		return new Integer(java.lang.Integer.parseInt(s.toString()));
	}

	public static Integer convert(String number) {
		return convert(number.toCharArray());
	}
	
}
