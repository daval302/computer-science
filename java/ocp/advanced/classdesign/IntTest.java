public class IntTest{

	public static void main(String[] args) {
		Integer one  = 1;
		Integer two = one;
		two++;

		System.out.println(one); // 1
		System.out.println(two); // 2
		System.out.println(one); // 2
	}
}