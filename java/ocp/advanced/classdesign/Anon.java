public class Anon{

	protected interface I{
		void f();
	}

	public static abstract class J{
		public  abstract void f();
	}

	void f (J j){
		j.f();
	}

	public static void main(String[] args) {
		
		// This is an anonim class
		I i = new I(){
			public void f(){
				System.out.println("inner impl 1");
			} 
		};
		i.f();

		// This is another anonim class
		Anon a  = new Anon();
		a.f( new J(){
			public void f(){
				System.out.println("inner impl 2");
			}
		} );


	}
}