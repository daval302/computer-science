abstract class Veichle {
	private String name;

	Veichle(String name){this.name = name;}

	public final String getName(){return name;}

	protected abstract void consumes();

	public String toString(){
		return String.format("Veichle[name=%s]", name);
	}
}

class Moto extends Veichle{

	Moto(){
		super("Moto");
	}

	protected void consumes(){
		System.out.println("Moto running");
	} 
}



class Car extends Veichle{

	Car(){
		super("Car");
	}

	protected void consumes(){
		System.out.println("Car running");
	} 
}

public class CarFactory{

	public static Veichle getVeichle(char v){
		switch(v){
			case 'm': return new Moto();
			case 'c': return new Car();
		}
		throw new UnsupportedOperationException("Unsupported Veichle");
	}

	public static void main(String[] args) {

		System.out.println( 
			CarFactory.getVeichle('m')
		);


		System.out.println( 
			CarFactory.getVeichle('c')
		);

		System.out.println( 
			CarFactory.getVeichle('s')
		);
		
	}
}