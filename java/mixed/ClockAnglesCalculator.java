public class ClockAnglesCalculator{

	public static double calculateAngle(int hours, int minutes){
		// 0hour -> 0 degress
		// 12 hours -> 360 degrees
		// 24 hours -> 720 degress

		// 1 degreee -> 360 / 12

		// 15 * DPH = > 360

		final double MINUTES_PER_HOUR = 60;
		final double DEGREES_PER_MINUTE = 360 / MINUTES_PER_HOUR;
		final double DEGREES_PER_HOUR = 360 / 12;

		double minutesAngle = minutes *  DEGREES_PER_MINUTE;
		double hourAngle = (hours * DEGREES_PER_HOUR) 
			+ (minutes / MINUTES_PER_HOUR) * DEGREES_PER_HOUR;

		hourAngle %= 360;

		return Math.abs(minutesAngle - hourAngle);



	}

	public static void main(String[] args) {
	
		int hour = 15;
		int minute = 00;

		System.out.println(calculateAngle(hour, minute));

	}
	
}