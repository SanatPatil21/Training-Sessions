package p1;

public class A
{
	public int x=10;
	private int y=20;
	protected int z=30;
	int q=40; 
	public static display()
	{
		System.out.println(x);
	}

}

class B extends A
{
	public void display()
	{
		System.out.println(x);
		System.out.println(z);
		System.out.println(q);
	}
	
}

class C
{
	public void display()
	{
		A a1=new A();
		System.out.println(a1.x);
		System.out.println(a1.z);
		System.out.println(a1.q);
	}


}