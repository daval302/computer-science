import java.util.Arrays;
import java.util.List;

public class FixedSizeList{

	public static void main(String[] args) {
		
		String [] array = {"hello", "man"};

		List<String> list  =  Arrays.asList(array);

		list.add("how are you"); // UnsupportedOperationException

		System.out.println(Arrays.toString(array));

	}
}