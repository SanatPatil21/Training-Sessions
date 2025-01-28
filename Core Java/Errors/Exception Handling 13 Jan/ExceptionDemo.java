import java.io.*;

class A{
	public void abc() throws NullPointerException,IOException,UserException,RuntimeException
	{
		//the unchecked exceptions(NullPointerException) are thrown implicitly, but its better to explicitly throw them.
		int a = 50;	
		for(int i=1;i<=20;i++)
		{
			System.out.println(i);
			int res = a/(a-i);
			//This is an Unchecked exception, so the program will compile regardless of the exception is handled or not.
			if(i==150)
				throw new NullPointerException();
			//This is an Checked exception, so the program will not compile(if not handled).
			if(i==12)
				throw new IOException();
			//If System.exit(0) used, then finally not executed. Rest all other cases, finally is executed.

			//When using UserException, we pass the message
			if(i==6)
				throw new UserException("When I is 2");

			//Using RuntimeUserException
			if(i==4)
				throw new RuntimeUserException("When I is 4");

		}
		
	}

	public void xyz() throws NullPointerException,IOException,UserException,RuntimeException
	{

		abc();
	}
	public void atoz() throws NullPointerException,IOException,UserException,RuntimeException
	{
		xyz();
	}
}



public class ExceptionDemo
{
	public static void main(String args[])
	{
		try{
			A a1 = new A();
			a1.atoz();
			//So now atoz() is called here. abc() has exceptions passed to xyz(), which passes it to atoz(), which then again passes it to the method calling it which being tha main method where it is finally handled.
		}catch(IOException e){
			System.out.println("IO Exception handler....");
		}
		//Multiple Exception Handler using pipeline operator(|)
		catch(NullPointerException | ArithmeticException e){
			System.out.println("Null Exception Handler");
		}
		catch(UserException e){
			System.out.println("Custom Exception Handler...");
			System.out.println("Reason: "+e.getMessage());
			e.getStackTrace();
			e.display();
	
		}
		catch(RuntimeUserException e){
			System.out.println("Custom Runtime Exception Handler...");
			System.out.println("Reason: "+e.getMessage());
			e.getStackTrace();
			e.display();

		}
		

		//Can catch all types of exception, but should not be used generally.
		catch(Exception e){
			System.out.println("Default Exception Handler......");

		}
		finally{
			System.out.println("Thank you!");
		}
		System.out.println("Program Continues....");
	}
	

}

//This custom exception should either extend Exception(if we want checked exception) or extend RuntineException(if we want a Unchecked exception)
class UserException extends Exception
{
	//Two constructors needs to be defined- 1: Unparamterised & 2: Parameterised(With string message passed from catch block)
	//Both constructors should call super() to map these constructors to the parent(Exception or RuntimeException) class constructors. 
	public UserException()
	{
		super();

	}
	public UserException(String msg)
	{
		super(msg);

	}
	//Along with getStackTrace, we can add our own custom methods.
	public void display()
	{
		System.out.println("My custom method display()....");
	}
}


class RuntimeUserException extends RuntimeException
{
	//This is a runtime exception, so it'll be unchecked. It will not stop execution
	public RuntimeUserException()
	{
		super();

	}
	public RuntimeUserException(String msg)
	{
		super(msg);

	}
	//Along with getStackTrace, we can add our own custom methods.
	public void display()
	{
		System.out.println("My custom method display() from RuntimeUserException....");
	}
}












