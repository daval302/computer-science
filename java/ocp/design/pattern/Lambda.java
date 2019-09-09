interface Check{
	void isOK(Lambda l);
}

public class Lambda{

	public void ok(Check c){
		c.isOK( this );
	}

	public String sayOk(){
		return "is ok";
	}

	public static void main(String[] args) {
		Lambda l = new Lambda();
		l.ok( p -> {
			System.out.println( p.sayOk() );
		} );
		
	}
}