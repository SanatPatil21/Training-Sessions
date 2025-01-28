import java.util.*;
	

public class CollectionDemo
{
	public static void main(String args[])
	{
		

		System.out.println("------------------------");
		LinkedHashMap<Integer,String> mobj =  new LinkedHashMap<Integer,String>();
		//Adding these generics basically add data type safety(constraints)
		mobj.put(111,"Rajesh");
		mobj.put(222,"Rakesh");
		mobj.put(333,"Ramesh");
		mobj.put(444,"Suresh");
		mobj.put(555,"Dinesh");

		Set s = mobj.entrySet();
		Iterator mi = s.iterator();
		while(mi.hasNext())
		{
			Map.Entry me = (Map.Entry) mi.next();
			System.out.println("ID: "+me.getKey());
			System.out.println("Name: "+me.getValue());		
		}
		//Hashtable does not allow null entries whereas HashMap does. Both of these use Iterator to iterate over the elements






















	}

}