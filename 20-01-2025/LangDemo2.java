import java.util.*;
import java.lang.reflect.*;

class A
{
	int x;
	A(int x)
	{
		this.x=x;
	}
	public void finalize()
	{
		System.out.println("Gaadi wala aaya Memory se kachra nikaal");
		System.out.println("Object with x value: "+x+" is getting removed");
	}
	
}

class Employee
{

	int x;
	public void raiseSalary(){
		System.out.println("This is raising salary");
	}
}

class Clerk extends Employee
{
	public String toString()
	{
		return "This is from Clerk Object";
	}

	public void ClerkKaKaam(){
		System.out.println("Clerk doing work");

	}

}

class Admin extends Employee
{
	public String toString()
	{
		return "This is from Admin Object";
	}
	public void AdminKaKaam(){
		System.out.println("Admin doing work");

	}

}



public class LangDemo2
{
	public static void main(String args[]) throws Exception
	{
		A a1 = new A(10);
		A a2 = new A(20);
		A a3 = new A(30);

		//a2.finalize();

		System.out.println(a1.x);
		System.out.println(a2.x);
		System.out.println(a3.x);

		a2 = null;
		//a1 = null;
		System.gc();


		Thread.sleep(1000);

		Class c1 = a1.getClass();


		//VERY VERY IMPORTANT
		//Helps us to create objects dynamically
		System.out.print("Enter class name: ");
		Class c2 = Class.forName(new Scanner(System.in).next());
		Object obj =  c2.newInstance();
		System.out.println(obj);

	
		Method methods[] = c2.getMethods();
		Field fields[]= c2.getFields();
		Constructor constructors[]= c2.getConstructors();


		System.out.println("class "+c2.getName());
		System.out.println("{");
		for(Method m :methods)
		{
			System.out.println("\t"+m);
	
		}
		System.out.println("}");

		System.out.print("Enter the method u want to do: ");
		Method method = c2.getMethod(new Scanner(System.in).next());
		method.invoke(c2);



		



		
	}
}
















