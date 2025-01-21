//This will explain the concept of "One class should be allowed to be extended by some classes and not by all"
//Add "sealed" to parent class and add "permits"-The classes which you want to allow inheritance
sealed class Manager permits SalesManager
{
	int x = 10;
	public void abc(){
		System.out.println("HI");
		
	}

}


class Clerk //extends Manager
{
	
}

//But the extended class should be final

//But if we want it not to be final, we can keep it non-sealed(behaves like a normal class) and can be extended by anyone.
non-sealed class SalesManager extends Manager
{

}

//This class also allows for DM to extend it
sealed class MarketingManager extends Manager permits DistributionManager
{

}

final class DistributionManager extends MarketingManager
{

}



public class CantInherit {
    public static void main(String args[]){
	B b1 = new B();
	System.out.println(b1.x);
	b1.abc();
        
    }
    
}
