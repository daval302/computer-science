import java.util.*;

public class Generics{

	final static void consume(List genericList){
		// System.out.println( ((String)genericList.get(0)) ); // ClassCastException for line 30
		System.out.println( genericList.get(0));		
	}

	public static void main(String[] args) {
		
		List list = new ArrayList(); // !! warning "unsafe operation" !!

		list.add("string from generic list");

		String s = (String ) list.get(0); // list elements are Object references
		//String s = list.get(0);	// !! Compile error !!	

		System.out.println(s);

		// case string list
		List<String> stringList = new ArrayList<>();
		stringList.add("string from string list");

		consume( stringList );


		// case generic list
		List genericList = new ArrayList();
		genericList.add( new StringBuilder( "StringBuilder from generic list" ));

		consume(genericList);


	}
}