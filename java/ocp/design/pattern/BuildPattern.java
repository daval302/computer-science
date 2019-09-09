final class Immutable{
	
	private final boolean b;
	private final String name;

	Immutable(boolean b, String name){
		this.b = b;
		this.name = name;
	}

	boolean getA(){return b;}
	String getName(){return name;}

	@Override
	public String toString(){
		return String.format( "Immutable[b=%b, name=%s]", b, name );
	}

}

// Tight coupled class with Build pattern

class ImmutableBuilder{

	private boolean b;
	private String name;

	public ImmutableBuilder setB(boolean b){ this.b = b; return this;}
	public ImmutableBuilder setName(String name){this.name = name; return this;}

	public Immutable build(){
		return new Immutable(b, name);
	}

}

public class BuildPattern{


	public static void main(String[] args) {

		ImmutableBuilder b = new ImmutableBuilder();
		Immutable i =  b.setB(true).setName("Caio").build();
		System.out.println(i);
		
	}
}