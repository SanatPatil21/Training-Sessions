interface X
{
	int a=50;
	void add();
	void sub();
}

interface Y
{
	int b=20;
	void mult();
	void div();
}

interface Z extends X,Y
{
}

class Calculator implements Z
{
	public void add()
	{
		System.out.println("Addition: "+(X.a+Y.b));
	}	
	public void sub()
	{
		System.out.println("Subttraction: "+(X.a-Y.b));
	}
	public void mult()
	{
		System.out.println("Multiplication: "+(Z.a*Z.b));
	}
	public void div()
	{
		System.out.println("Division: "+(X.a/Y.b));
	}
}

public class Main{
	public static void main(String agrs[])
	{
		Calculator c1 = new Calculator();
		//Since this calculator object points to the X interface, it can only access methods of X interface
		X x1 = c1;
		x1.add();
		x1.sub();
		System.out.println("-------------------");
		
		//Similary this can only access Y interface
		Y y1=c1;
		y1.mult();
		y1.div();
		System.out.println("-------------------");
		
		
		//Since Z can extended both interfaces, it can access methods of both of those interfaces
		Z z1=c1;
		z1.add();
		z1.mult();
		
		//This in turn can be used for giving specific features to specific customers/customers.
		//Note:- Interface varibles are Global, Static & Final, so they can be used anywhere(Global Scope).
	
	}
}