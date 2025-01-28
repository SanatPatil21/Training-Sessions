class A
{
	static int x;
	static int y = 20;
	public static void abc()
	{	
		//Static methods can only access static methods or static variables.
		System.out.println("From static method: "+y);
	}
}
public class staticDemo
{
	static
	{
		System.out.println("from the static block, pehla wala....");
	}
	public static void main(String args[])
	{
		System.out.println(A.x);
		A a1 = new A();
		A a2 = new A();
		A a3 = new A();	

		a1.x=10;
		a2.x=20;
		a3.x=30;

		System.out.println(a1.x);
		System.out.println(a2.x);
		System.out.println(a3.x);

		A.abc();
	}

	static
	{
		System.out.println("from the static block,dusra wala....");
	}

}