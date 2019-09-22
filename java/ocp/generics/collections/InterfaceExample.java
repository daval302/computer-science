interface Greetings<T>{
	public abstract T say();
}

// Type 1 implementing Generic Interface

class ItalianGreetings implements Greetings<String>{
	public String say(){ return "Ciao"; }
}

// Type 2 : specify a new class with generic parameter

class EnglishGreetings<T> implements Greetings<String>{
	public String say(){ return "Hello"; }
}

// Type 3 Raw Type

class Strager{public String toString(){return "I am a stranger";}}

class StrangeGreetings implements Greetings{
	public Strager say(){return new Strager(); } 
}


public class InterfaceExample{



	public static void main(String[] args) {

		System.out.println(new ItalianGreetings().say());
		System.out.println(new EnglishGreetings().say());
		System.out.println(new StrangeGreetings().say());

	}
}