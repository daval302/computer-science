import java.util.*;

public class Generics{

	public static void main(String[] args) {
		
		List list = new ArrayList(); // !! warning !!

		list.add("hello");

		String s = (String ) list.get(0); // list elements are Object references
		//String s = list.get(0);	// !! Compile error !!	

		System.out.println(s);

	}
}