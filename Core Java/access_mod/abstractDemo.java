abstract class A
{
	A()
	{
	}
	public void xyz(){}
	public abstract void abc();

}

abstract class B extends A
{
	
}

//Any non abstract class should be compulsarily implementing the abstract methods inherited from its parent abstract class.
class C extends B
{
	public void abc()
	{

	}
}
public class Abstractdemo()
{
	public static void main(String args[])
	{
		B b1 = new B();

	}
}