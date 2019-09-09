final class Go{
	private Go(){}

	private static volatile Go go;

	public static final  Go getInstance(){
		if (go == null)
			synchronized(Go.class){
				if (go == null)
					go = new Go();
			}
			
		return go;
	}

}

public class Volatile{

	public static void main(String[] args) {
		System.out.println(

			Go.getInstance()
			);
	}

}