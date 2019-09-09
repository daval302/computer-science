public class Outer2 {

	private String greeting = "Hi";

	private class Inner {
		public int repeat = 3;
		public void go() {
			for (int i = 0; i < repeat; i++)
				System.out.println(greeting);
		}
	}

	public void callInner() {
		Inner inner = new Inner();
		inner.go();
	}
	
	public static void main(String[] args) {
		Outer2 outer = new Outer2();
		outer.callInner();

		Inner i = outer.new Inner();
	} 
}