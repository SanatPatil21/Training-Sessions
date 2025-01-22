import java.util.*;
	

public class CollectionDemo
{
	public static void main(String args[])
	{
		Vector v1 = new Vector(2);
		v1.add("HELOO");
		v1.add(2334);
		v1.add(new Date());
		v1.add(new Thread());
		v1.add(324.33);

		Enumeration e = v1.elements();
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}


		System.out.println("------------------------");
		HashSet obj = new HashSet();
		//TreeSet obj = new TreeSet();
		//LinkedHashSet obj = new LinkedHashSet();

		//ArrayList obj = new ArrayList();
		//PriorityQueue obj = new PriorityQueue();

		//ArrayDeque obj = new ArrayDeque();
	

		obj.add(777);
		obj.add(222);
		obj.add(666);
		obj.add(444);
		obj.add(555);

		Iterator i = obj.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
	
		}


		System.out.println("------------------------");
		//It is not an implementation of Collection Interface
		//So .add() doesnt work

		Hashtable mobj = new Hashtable();
		mobj.put("111","Rajesh");
		mobj.put("222","Rakesh");
		mobj.put("333","Ramesh");
		mobj.put("444","Suresh");
		mobj.put("555","Dinesh");

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