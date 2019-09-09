import java.util.function.Predicate;

public class Pred{

	private boolean ok = true;

	public boolean isOk(Predicate<Pred> p){
		return p.test(this);
	}

	public Pred change(){
		ok = !ok;
		return this;
	}

	public static void main(String[] args) {
		
		System.out.println(
			new Pred().isOk( p -> p.ok )
		);

		System.out.println(
			new Pred().change().isOk( p -> p.ok )
		);

	}
}