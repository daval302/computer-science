final class Ton{
	
	private static Ton ton = new Ton(); 

	private boolean ok = true;

	private Ton(){}

	public static synchronized Ton getInstance(){return ton;}

	public synchronized Ton change(){
		ton.ok = !ton.ok;
		return ton;
	}

	public synchronized boolean isOk(){return ton.ok;}

}

public class Single{


	public static void main(String[] args) {
		System.out.println(
			Ton.getInstance().change().change().isOk()
			);
	}
}