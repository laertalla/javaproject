package lessontwo;

public class Exercise3 {
	
	public static void main(String[] args) {
	
		DigitalClock clock1 = DigitalClock.getDigitalClock();
				
		System.out.println(clock1.getDigitalClockAsString());
	
		DigitalClock clock2 = DigitalClock.getDigitalClock();
		
		System.out.println(clock2.getDigitalClockAsString());
		
		System.out.println(clock1 == clock2);
		
		DigitalClock clock3 = DigitalClock.getDigitalClock(4000);
		System.out.println(clock3.getDigitalClockAsString());
	
		DigitalClock clock4 = DigitalClock.getDigitalClock(clock2);
		System.out.println(clock4.getDigitalClockAsString());
	
	}

}
