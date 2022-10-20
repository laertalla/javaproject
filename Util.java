package extra;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import lessontwo.DigitalClock;

public class Util {
	
	/***
	 *	By default makina virtuale 32-bit vepron me referenca
	 *	po ashtu 32-bit (pra, 4 byte).
	 *	Makina virtuale 64 bit vepron me referenca po ashtu
	 *	64-bit, mund te konfigurohet qe te veproj me referenca
	 *	32 bit.
	 *
	 *
	 *	Operatoret e gjuhes Java:
	 *
	 *		i perzgjedhjes		.	
	 *							+
	 *							-
	 *							*
	 *							/
	 *							%
	 *							=
	 *							+=
	 *							-=
	 *							*=
	 *							/=
	 *							%=
	 *							++
	 *							--
	 *							>
	 *							<
	 *							>=
	 *							<=
	 *							==
	 *							!=
	 *							&&
	 *							&
	 *							||
	 *							|
	 *							!
	 *							^
	 *							(arg0) ? arg1 : arg2
	 *							new
	 *	
	 *	struktura
	 *			
	 *		if
	 *		if	else
	 *		switch
	 *		while
	 *		do while
	 *		for
	 *
	 *	metoda
	 *		
	 *		modifikues tip emer(liste parametrave){
	 *			instruksione
	 *		}
	 *
	 *	struktura te dhenash lineare
	 *
	 *		array	(vektor)	
	 *		array 2d	(matrix)
	 *		list	(ArrayList)
	 *
	 *	
	 *
	 *	fjale kyce
	 *
	 *		package 
	 *		import
	 *		public
	 *		class
	 *		static
	 *		void
	 *		new
	 *		boolean
	 *		byte
	 *		short
	 *		char
	 *		int
	 *		long
	 *		float
	 *		double
	 *		if
	 *		else
	 *		switch
	 *		while
	 *		do
	 *		for
	 *		break
	 *		continue
	 *		return
	 *		final
	 *		false
	 *		true
	 *		null 				
	 **/
	
	public static final Scanner input =	new Scanner(System.in);
	
	public static boolean equalArrays(int[] a1, int[] a2) {
		if(a1.length != a2.length) {
			return false;
		}
		for (int i = 0; i < a1.length; i++) {
			if(a1[i] != a2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void sortIntArray(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			int indexMin = i;
			for(int j = i + 1; j < a.length; j++) {
				if(a[j] < a[indexMin]) {
					indexMin = j;
				}
			}
			int temp = a[i];
			a[i] = a[indexMin];
			a[indexMin] = temp;
		}
	}
	
	public static boolean sortedEqualArrays(int[] a1, int[] a2) {
		if(a1.length != a2.length) {
			return false;
		}
		sortIntArray(a1);
		sortIntArray(a2);
		for (int i = 0; i < a1.length; i++) {
			if(a1[i] != a2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static long randomValue (long minValue, long maxValue) {
		if(minValue > maxValue) {
			long tmp = minValue;
			minValue = maxValue;
			maxValue = tmp;
		}
		return (long)(Math.random() * (maxValue - minValue + 1)) + minValue;
	}

	public static double getSum(ArrayList<Double> list) {
		double sum = 0;
		for(double value : list) {
			sum += value;
		}
		return sum;
	}
	
	public static String nextLine() {
		String s = input.nextLine().trim();
		while(s.isEmpty()) {
			s = input.nextLine().trim();
		}
		return s;
	}

	public static String millisOfDateToString(long dateInMillis) {
		GregorianCalendar date = new GregorianCalendar();		
		date.setTimeInMillis(dateInMillis);
		return millisOfDateToString(date);
	}

	public static String millisOfDateToString(GregorianCalendar date) {
		return String.format("%02d/%02d/%04d", 
							 date.get(GregorianCalendar.DAY_OF_MONTH),
							 date.get(GregorianCalendar.MONTH) + 1,
							 date.get(GregorianCalendar.YEAR));
	}

	public static boolean isSmallerThan(char[] a1, char[] a2) {
		if(a1 == null || a2 == null || 
		   (a1.length == 0 && a2.length == 0)) {
			return false;
		}
		if(a1.length == 0) {
			if(a2[0] == '+' || Character.isDigit(a2[0])) {
				return true;
			}
			return false;
		}
		if(a2.length == 0) {
			if(a2[0] == '-') {
				return true;
			}
			return false;
		}
		if(a1[0] == '-' && a2[0] == '+') {
			return true;
		}
		if(a1[0] == '+' && a2[0] == '-') {
			return false;
		}
		if(a1[0] == '-' && a2[0] == '-') {
			if(a1.length > a2.length) {
				return true;
			}
			if(a1.length < a2.length) {
				return false;
			}
			for(int i = 0; i < a1.length; i++) {
				if(a1[i] > a2[i]) {
					return true;
				}
			}
			return false;
		}
		if(a1[0] == '+' && a2[0] == '+') {
			if(a1.length < a2.length) {
				return true;
			}
			if(a1.length > a2.length) {
				return false;
			}
			for(int i = 0; i < a1.length; i++) {
				if(a1[i] < a2[i]) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public static boolean isGreaterThan(char[] cs, char[] cs2) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getSecondsFromMidnight() {
		return (int) (System.currentTimeMillis() / 
					   DigitalClock.MILLIS_IN_SECOND % 
					   DigitalClock.SECONDS_IN_DAY);
	}

	public static int getDaysOfEpoch() {
		return (int) (System.currentTimeMillis() / 
				   	  DigitalClock.MILLIS_IN_SECOND / 
				      DigitalClock.SECONDS_IN_DAY) + 1;
	}
	
}










