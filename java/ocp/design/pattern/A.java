interface Check{
	boolean test(String s, String q);
}

public class A {

	public static boolean find(String s, String q, Check c){
		return c.test(s,q);
	}

	public static void main(String[] args) {
		System.out.println( 
			find(  "ciao", "cia",  (s, q) -> s.equals(q) ) 
		);
	}

}