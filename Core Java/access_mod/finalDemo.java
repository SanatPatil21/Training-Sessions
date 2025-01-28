class A
{
	final int x = 10;

	public final void abc()
	{
		System.out.println("Hi");
	}

}
//Now this final method cannot be overidden by overidden by child class

//Now this class b cannot be extended
final class B extends A
{

}


public class finalDemo
{
	public static void main(String args[])
	{
		A a1=new A();
		System.out.println(a1.x);
		//a1.x=50;
		System.out.println(a1.x+50);

		a1.abc();

		B b1 = new B();
		b1.abc();


	
	}
}