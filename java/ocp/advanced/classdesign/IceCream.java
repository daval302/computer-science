public class IceCream {

	enum Flavors {
	VANILLA, CHOCOLATE, STRAWBERRY
	}

	public static void main(String[] args) {
		
		Flavors f = Flavors.VANILLA;
		
		switch (f) {
			case VANILLA: System.out.println("vanilla");
			case CHOCOLATE: System.out.println("chocolate");
			case STRAWBERRY: System.out.println("strawberry");
			break;
			default: System.out.println("missing flavor");
		}
	}
}