package advanced.classdesign.b;

import advanced.classdesign.A;

public class B extends A{

	public static void main(String[] args) {
		
		A a = new B();
		
		B b = new B();
		
		// This is a "variable access"
		System.out.println(a.name); // A
		
		// This is an "inheritateed access"
		System.out.println(b.name); // Compile ERORR !!
	}
}