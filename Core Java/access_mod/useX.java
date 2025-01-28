import com.X;


class Y 
{
	public void display()
	{
		//We cannot create object and call it through that object, we need to directly access it.
		System.out.println(a);
		demo();

	}


}

class UseXclass
{
	public static void main(String args[])
	{
	 	Y y1=new Y();
		y1.display();

	}
}