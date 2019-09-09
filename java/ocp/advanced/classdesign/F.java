
public class F{

	private String field = "F";

	@Override
	public boolean equals(Object o){
		if (!(o instanceof F))
			return false;
		F f = (F) o;
		return f.field.equals(this.field);
	}

	public static void main(String[] args) {
		
		String s1 = "Canada";
		String s2 = new String(s1);
		if(s1 == s2) System.out.println("s1 == s2");
		if(s1.equals(s2)) System.out.println("s1.equals(s2)");
		
	}

}