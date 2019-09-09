public class Employee {
	
	public int employeeId;
	
	public String firstName, lastName;
	
	public int yearStarted;
	
	@Override public int hashCode() {
		return employeeId;
	}

	public boolean equals(Employee e) {
		return this.employeeId == e.employeeId;
	}

	public static void main(String[] args) {
		
		String a = new String("asd");
		String b = "asd";

		System.out.println(a.equals(b));
		System.out.println(a.hashCode() == b.hashCode());
	} 
}