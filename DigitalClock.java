package lessontwo;

import extra.Util;

public class DigitalClock {

	public static final byte MIN_HOUR_VALUE = 0;
	public static final byte MAX_HOUR_VALUE = 23;

	public static final byte MIN_MINUTE_VALUE = 0;
	public static final byte MAX_MINUTE_VALUE = 59;

	public static final byte MIN_SECONDS_VALUE = 0;
	public static final byte MAX_SECONDS_VALUE = 59;
	
	public static final byte SECONDS_IN_MINUTE = 60;
	public static final short SECONDS_IN_HOUR = 3_600;
	public static final int SECONDS_IN_DAY = 86_400;

	public static final byte MIN_SECONDS_IN_DAY = 0;
	public static final int MAX_SECONDS_IN_DAY = 86_399;
	
	public static final byte MINUTE_IN_HOUR = 60;
	public static final short MILLIS_IN_SECOND = 1_000;
	
	private static final int MAX_NUMBER_OF_DIGITAL_CLOCKS = SECONDS_IN_DAY;
	
	private byte hour;
	private byte minute;
	private byte seconds;
	
	private static final DigitalClock[] CREATED = new DigitalClock[MAX_NUMBER_OF_DIGITAL_CLOCKS];
	
//	private DigitalClock() {
//		this(Util.getSecondsFromMidnight());
//	}
	
	private DigitalClock(int secondsFromMidnight) {
		//ky konstruktor kontrollon nese sekondat nga mesnata jan brenda nje dite
		//me vleren e tyre llogarit oren minutat dhe sekondat
		hour = (byte) (secondsFromMidnight / SECONDS_IN_HOUR);
		minute = (byte) (secondsFromMidnight % SECONDS_IN_HOUR / SECONDS_IN_MINUTE);
		seconds = (byte) (secondsFromMidnight % SECONDS_IN_HOUR % SECONDS_IN_MINUTE);
	}
	
//	private DigitalClock(int hour, int minute, int seconds) {
//		//ky konstruktor kontrollon vlerat nese jan okay
//		//me marrveshje vem minimumin
//		if(hour < MIN_HOUR_VALUE || hour > MAX_HOUR_VALUE) {
//			hour = MIN_HOUR_VALUE;
//		}
//		if(minute < MIN_MINUTE_VALUE || minute > MAX_MINUTE_VALUE) {
//			minute = MIN_MINUTE_VALUE;
//		}
//		if(seconds < MIN_SECONDS_VALUE || seconds > MAX_SECONDS_VALUE) {
//			seconds = MIN_SECONDS_VALUE;
//		}
//		this.hour = (byte) hour;
//		this.minute = (byte) minute;
//		this.seconds = (byte) seconds;
//	}
	
//	private DigitalClock(DigitalClock digitalClock) {
//		//do ruaj te njejtat vlera si argumenti
//		if(digitalClock == null) {
//			hour = MIN_HOUR_VALUE;
//			minute = MIN_MINUTE_VALUE;
//			seconds = MIN_SECONDS_VALUE;
//			return;
//		}
//		hour = digitalClock.hour;
//		minute = digitalClock.minute;
//		seconds = digitalClock.seconds;
//	}
	
	public static DigitalClock getDigitalClock() {
//		int seconds = Util.getSecondsFromMidnight();
//		if(CREATED[seconds] == null) {
//			CREATED[seconds] = new DigitalClock();
//		}
//		return CREATED[seconds];
		return getDigitalClock(Util.getSecondsFromMidnight());
	}
	
	public static DigitalClock getDigitalClock(int secondsFromMidnight) {
		if(secondsFromMidnight < MIN_SECONDS_IN_DAY) {
			secondsFromMidnight = MIN_SECONDS_IN_DAY;
		}
		else if(secondsFromMidnight > MAX_SECONDS_IN_DAY) {
			secondsFromMidnight = secondsFromMidnight % SECONDS_IN_DAY;
		}
		if(CREATED[secondsFromMidnight] == null) {
			CREATED[secondsFromMidnight] = new DigitalClock(secondsFromMidnight);
		}
		return CREATED[secondsFromMidnight];
	}

	public static DigitalClock getDigitalClock(int hour, int minute, int seconds) {
		if(hour < MIN_HOUR_VALUE || hour > MAX_HOUR_VALUE) {
			hour = MIN_HOUR_VALUE;
		}
		if(minute < MIN_MINUTE_VALUE || minute > MAX_MINUTE_VALUE) {
			minute = MIN_MINUTE_VALUE;
		}
		if(seconds < MIN_SECONDS_VALUE || seconds > MAX_SECONDS_VALUE) {
			seconds = MIN_SECONDS_VALUE;
		}
		return getDigitalClock(getSeconds(hour, minute, seconds));
	}

	public static int getSeconds(int hour, int minute, int seconds) {
		return hour * SECONDS_IN_HOUR + minute * SECONDS_IN_MINUTE + seconds;
	}

	public static DigitalClock getDigitalClock(DigitalClock digitalClock) {
		if(digitalClock == null) {
			return null;
		}
		return getDigitalClock(getSeconds(digitalClock.hour, digitalClock.minute, digitalClock.seconds));
	}
	
	public byte getHour() {
		return hour;
	}
	
	public byte getMinute() {
		return minute;
	}
	
	public byte getSeconds() {
		return seconds;
	}

	public String getDigitalClockAsString() {
		return String.format("%02d:%02d:%02d", hour, minute, seconds);
	}
	
}
