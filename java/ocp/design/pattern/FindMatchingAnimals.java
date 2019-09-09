import java.util.function.Predicate;

class Animal {
	
	private String species;
	
	private boolean canHop;
	
	private boolean canSwim;
	
	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}

	public boolean canHop() { 
		return canHop; 
	}

	public boolean canSwim() { 
		return canSwim; 
	}
	
	public String toString() {
		return species; 
	}
}

public class FindMatchingAnimals {
	
	private static void print(Animal animal, Predicate<Animal> trait) {
		if(trait.test(animal))
		System.out.println(animal);
	}
	
	public static void main(String[] args) {
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), a -> a.canHop());
	}
}