public class SwapVariables{
	
	int x;
	int y;

	SwapVariables(int x,int y){
		this.x = x;
		this.y = y;
	}

	public void swap() {
	    x = x + y;
	    y = x - y;
	    x = x - y;
	}

	public static void main(String[] args) {
		
		SwapVariables vars = new SwapVariables(1,2);
		vars.swap();

		System.out.println(vars.x);
		System.out.println(vars.y);
	}
}