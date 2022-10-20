package lessontwo;

import java.util.GregorianCalendar;

import extra.Util;

public class Exercise4 {
	
	public static void main(String[] args) {
	
		long seconds = 0;
		
		short year = 1970;
		while(year < 3000) {
			System.out.println(new Date((int) (seconds / DigitalClock.SECONDS_IN_DAY)).getDate());
			GregorianCalendar c = new GregorianCalendar();
			c.setTimeInMillis(seconds * DigitalClock.MILLIS_IN_SECOND);
			System.out.println(Util.millisOfDateToString(c.getTimeInMillis()));
			seconds = seconds + DigitalClock.SECONDS_IN_DAY;
			year = (short) c.get(GregorianCalendar.YEAR);
		}
		
	}

}
