package p2;

import p1.A;

public class D
{
	public void display()
	{
		A a1=new A();
		Sytem.out.println(a1.x);
	}
	
}

class E extends A
{
	public void display()
	{
		System.out.println(x);
		System.out.println(z);

	}
}

class F extends E
{
	public void display()
	{

	}
}