final class Ton{
	private static Ton ton;

	private int ammount  = 0;

	private Ton(){}

	public static synchronized Ton getInstance(){
		if (ton == null)
			ton = new Ton();
		return ton;
	}

	public synchronized int  getAmmount(){
		return getInstance().ammount;
	}

	public synchronized Ton setAmmount(int n){
		getInstance().ammount = n;
		return ton;
	}
}

public class Lazy{

	public static void main(String[] args) {

		System.out.println(
			Ton.getInstance().setAmmount(10).getAmmount()
		);
		
	}
}