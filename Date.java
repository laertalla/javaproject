package lessontwo;

import extra.Util;

public class Date {
	
	public static final byte MIN_MONTH_VALUE = 1;
	public static final byte MAX_MONTH_VALUE = 12;
	
	public static final byte JANUARY_VALUE = 1; 
	public static final byte FEBRUARY_VALUE = 2;
	public static final byte MARCH_VALUE = 3;
	public static final byte APRIL_VALUE = 4;
	public static final byte MAY_VALUE = 5;
	public static final byte JUNE_VALUE = 6;
	public static final byte JULY_VALUE = 7;
	public static final byte AUGUST_VALUE = 8;
	public static final byte SEPTEMEBER_VALUE = 9;
	public static final byte OCTOBER_VALUE = 10;
	public static final byte NOVEMEBER_VALUE = 11; 
	public static final byte DECEMBER_VALUE = 12; 
	
	public static final byte MIN_DAY_VALUE = 1;
	public static final byte MAX_DAY_VALUE = 31;

	public static final byte JANUARY_MAX_DAYS_VALUE = 31;
	public static final byte FEBRUARY_MAX_DAYS_VALUE = 29;
	public static final byte MARCH_MAX_DAYS_VALUE = 31;
	public static final byte APRIL_MAX_DAYS_VALUE = 30;	
	public static final byte MAY_MAX_DAYS_VALUE = 31;
	public static final byte JUNE_MAX_DAYS_VALUE = 30;
	public static final byte JULY_MAX_DAYS_VALUE = 31;
	public static final byte AUGUST_MAX_DAYS_VALUE = 31;
	public static final byte SEPTEMEBER_MAX_DAYS_VALUE = 30;
	public static final byte OCTOBER_MAX_DAYS_VALUE = 31;
	public static final byte NOVEMEBER_MAX_DAYS_VALUE = 30;
 	public static final byte DECEMBER_MAX_DAYS_VALUE = 31;
	
	public static final short FIRST_YEAR = 1970;
	public static final short FIRST_LEAP_YEAR = 1972;
	public static final byte MIN_DAYS_FROM_FIRST_YEAR = 1;
	
	public static final short DAYS_OF_YEAR = 365;
	public static final short DAYS_OF_LEAP_YEAR = 366;
	
	private byte day;
	private byte month;
	private short year;
	
	public Date() {
		this(Util.getDaysOfEpoch());
	}
	
	public Date(int daysFromFirstYear) {
		if(daysFromFirstYear < MIN_DAYS_FROM_FIRST_YEAR) {
			daysFromFirstYear = MIN_DAYS_FROM_FIRST_YEAR;
		}
		int days = daysFromFirstYear;
		short daysOfYear;
		year = FIRST_YEAR;
		while(days > (daysOfYear = daysOfYear(year))) {
			days = days - daysOfYear;
			year++;
		}
		short daysOfActualYear = (short) days;
		byte [] daysOfMonth = getDaysOfMonth(year);
		byte [] month = getMonths();
		byte i = 0;
		while(i < 12 && daysOfActualYear > daysOfMonth[i]) {
			daysOfActualYear -= daysOfMonth[i];
			i++;
		}
		this.month = month[i];
		day = (byte) daysOfActualYear;
	}
	
	private byte[] getMonths() {
		return new byte[]{
							JANUARY_VALUE,
							FEBRUARY_VALUE,
							MARCH_VALUE,
							APRIL_VALUE, 
							MAY_VALUE,
							JUNE_VALUE,
							JULY_VALUE,
							AUGUST_VALUE,
							SEPTEMEBER_VALUE,
							OCTOBER_VALUE,
							NOVEMEBER_VALUE,
							DECEMBER_VALUE
				};
	}

	public static byte[] getDaysOfMonth(short year) {
		return new byte[] {
							JANUARY_MAX_DAYS_VALUE, 
							isLeapYear(year) ? FEBRUARY_MAX_DAYS_VALUE : FEBRUARY_MAX_DAYS_VALUE - 1,
							MARCH_MAX_DAYS_VALUE,
							APRIL_MAX_DAYS_VALUE,
							MAY_MAX_DAYS_VALUE,
							JUNE_MAX_DAYS_VALUE,
							JULY_MAX_DAYS_VALUE, 
							AUGUST_MAX_DAYS_VALUE,
							SEPTEMEBER_MAX_DAYS_VALUE,
							OCTOBER_MAX_DAYS_VALUE,
							NOVEMEBER_MAX_DAYS_VALUE, 
							DECEMBER_MAX_DAYS_VALUE
			   };
	}

	public static short daysOfYear(int year) {
		return isLeapYear(year) ? DAYS_OF_LEAP_YEAR : DAYS_OF_YEAR;
	}
	
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
	
	public Date(int day, int month, int year) {
		if(day < MIN_DAY_VALUE || day > MAX_DAY_VALUE) {
			day = MIN_DAY_VALUE;
		}
		if(month < MIN_MONTH_VALUE || day > MAX_MONTH_VALUE) {
			month = MIN_MONTH_VALUE;
		}
		if(year < FIRST_YEAR) {
			year = FIRST_YEAR;
		}
		if(has30Days(month)) {
			if(day == MAX_DAY_VALUE) {
				day = MIN_DAY_VALUE;
			}
		}else if(month == FEBRUARY_VALUE) {
			if(isLeapYear(year)) {
				if(day > FEBRUARY_MAX_DAYS_VALUE) {
					day = MIN_DAY_VALUE;
				}
			}else {
				if(day > FEBRUARY_MAX_DAYS_VALUE - 1) {
					day = MIN_DAY_VALUE;
				}
			}
		}
		if(year < FIRST_YEAR) {
			year = FIRST_YEAR;
		}
		this.day = (byte) day;
		this.month = (byte) month;
		this.year = (short) year;
	}
	
	private boolean has30Days(int month) {
		return month == APRIL_VALUE || 
			   month == JUNE_VALUE || 
			   month == SEPTEMEBER_VALUE || 
			   month == NOVEMEBER_VALUE;
	}

	public Date(Date date) {
		if(date == null) {
			day = MIN_DAY_VALUE;
			month = JANUARY_VALUE;
			year = FIRST_YEAR;
			return;
		}
		day = date.day;
		month = date.month;
		year = date.year;
	}
	
	public byte getDay() {
		return day;
	}
	
	public byte getMonth() {
		return month;
	}
	
	public short getYear() {
		return year;
	}

	public String getDate() {
		return String.format("%02d/%02d/%d", day, month, year);
	}
	
}
