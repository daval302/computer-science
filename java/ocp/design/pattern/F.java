import java.util.function.Predicate;

interface Cazzo{
	void test( R r );
}

class R{
	public boolean isOk(){return true;}
}

public class F{

	public static void f(Predicate<R> p){
		if (p.test( new R() ))
			System.out.println("isOk");
	}

	public static void main(String[] args) {
		f(p -> p.isOk());
	}
}