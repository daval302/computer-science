public class LocalInnerClass{

	public static int x = 10;

	void f(){
		final int x = 20;
		LocalInnerClass.x++;
		class Inner{
			void f(){
				System.out.println(x);
				System.out.println(LocalInnerClass.x);
			}	
		}
		Inner i = new Inner();
		i.f();
	}

	public static void main(String[] args) {
		LocalInnerClass l = new LocalInnerClass();
		l.f();
	}
}