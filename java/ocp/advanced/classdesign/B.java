package advanced.classdesign;

import advanced.classdesign.A;

public class B extends A{

	public static void main(String[] args) {
		
		A a = new B();
		
		// This is a variable access to protected method accessible withing the same package
		System.out.println(a.name); // A
	}
}