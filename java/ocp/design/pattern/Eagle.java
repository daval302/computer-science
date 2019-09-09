interface Fly {

	public int getWingSpan() throws Exception;

	public static final int MAX_SPEED = 100;
	
	public default void land() {
			System.out.println("Animal is landing");
	}
	
	public static double calculateSpeed(float distance, double time) {
		return distance/time;
	}

	static int f(){ return MAX_SPEED;}
}
	
public class Eagle implements Fly {
	
	public int getWingSpan() {
		return 15;
	}
	
	public void land() {
		System.out.println("Eagle is diving fast");
	}

	public static void main(String[] args) {
		System.out.println(Fly.calculateSpeed(12.05f, 123.123f));
		System.out.println( Fly.f() );
		
	}
}