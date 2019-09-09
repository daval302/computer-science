public class Q {
	private int x = 10;
	class B {
		private int x = 20;
		class C {
			private int x = 30;
			public void allTheX() {
				System.out.println(x); // 30
				System.out.println(this.x); //30
				System.out.println(B.this.x); //20
				System.out.println(Q.this.x); // 10
			} 
		} 
	}

	public static void main(String[] args) {
		Q a = new Q();
		Q.B b = a.new B();
		Q.B.C c = b.new C();
		c.allTheX();
	}
}