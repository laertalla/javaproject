package lessontwo;

public class Moment {

	private Date date;
	private DigitalClock time;

	public Moment() {
		date = new Date();
		time = DigitalClock.getDigitalClock();
	}

	public Date getDate() {
		return date;
	}

	public DigitalClock getTime() {
		return time;
	}

}
