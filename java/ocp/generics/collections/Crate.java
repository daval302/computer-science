class Cat{
	@Override
	public String toString(){return "Cat of size ";}
}

class Dog{
	@Override
	public String toString(){return "Dog";}
}

public class Crate<T, U> {

	private T contents;
	private U size;

	public Crate(U size){
		this.size = size;
	}

	public Crate(T elem, U size){
		this.contents = elem;
		this.size = size;
	}
	
	public T emptyCrate() {
		return contents;
	}

	public void packCrate(T contents) {
		this.contents = contents;
	}

	public static void main(String[] args) {
		
		Crate<Cat, Integer> crateForCat = new Crate<>(10);
		crateForCat.packCrate(new Cat());

		Crate<Dog, Integer> crateForDog = new Crate<>(15);
		crateForDog.packCrate(new  Dog() );

		System.out.println( crateForCat.emptyCrate() );		// Cat
		System.out.println( crateForDog.emptyCrate() );		// Dog


	}
}