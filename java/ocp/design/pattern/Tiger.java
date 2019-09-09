class Animal {
	@Override
	public String toString(){
		return "General Animal";
	}
}

@FunctionalInterface
interface Sprint {
	public void sprint(Animal animal);
}

public class Tiger implements Sprint {
	
	public void sprint(Animal animal) {
		System.out.println("Animal is sprinting fast! "+animal.toString());
	}

	public static void main(String[] args) {
		Tiger t = new Tiger();
		t.sprint(new Animal());
	}
}