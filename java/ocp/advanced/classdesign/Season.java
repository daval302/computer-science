enum SeasonEnum {
	
	WINTER("Low"), SPRING("Medium"), SUMMER("High"), FALL("Medium");
	
	private String expectedVisitors;

	private SeasonEnum(String expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}

	public void printExpectedVisitors() {
		System.out.println(expectedVisitors);
	}
} 

public class Season{
	public static void main(String[] args) {
		SeasonEnum s = SeasonEnum.valueOf("Low");
	}
}