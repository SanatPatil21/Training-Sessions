interface I{
	//From Java v1
	public void abc();
	//Only from Java v8
	public default void xyz(){
		System.out.println("I.xyz()");
	}
	// Only from v8
	public static void atoz(){
		System.out.println("I.atoz()");
	}
	// Only from V9
	private void demo(){
		System.out.println("Private method in interface");
	}
}

class A implements I{
	public void abc(){
		System.out.println("A.abc()");

	}
}

interface X{

	public default void hello(){
		System.out.println("From X interface hello() method");

	}

}

interface Y{

	public default void hello(){
		System.out.println("From Y interface hello() method");

	}

}
class B implements X,Y{
	public void hello(){
		X.super.hello();
		Y.super.hello();

	}
}


public interface NewInterface{
	public static void main(String args[]){
		System.out.println("Heelo Boizzz");

		B b1 = new B();
		b1.hello();

	}

}