public class Enclosing {

	static class Nested {
		private int price = 6;

		Nested(){
			price++;
		}
	}

	public static void main(String[] args) {

		Enclosing e  = new Enclosing();
		
		Nested nested = new Nested(); // static initializaione 
		
		// Nested nested = e.new Enclosing() // instance initializing
		System.out.println(nested.price);
	
	} 
}