import java.util.*;

public class UtilDemo
{	
	public static void main(String args[])
	{
		Date d1 = new Date();
		System.out.println(d1);
		System.out.println(d1.getTime());
		Date d2 = new Date();
		d2.setTime(-9993992492374L);


		//It uses 0-11 for the 12 months
		//setMonth(input) -> input/12 -> Quotient=Years, Remainder=Months
		d1.setMonth(48);
		System.out.println(d1);
		System.out.println(1900+d1.getYear());


		System.out.println("---------------------");
		Stack s1 = new Stack();
		s1.push("1111");
		s1.push("2222");
		s1.push("3333");
		s1.push("4444");
		s1.push("5555");

		//pop() removes the element while peek() doesn't
		//Both output the topmost element
		System.out.println(s1.pop());
		System.out.println(s1.peek());


		BitSet b1 = new BitSet(16); //0000 0000 0000 0000
		BitSet b2 = new BitSet(16); //0000 0000 0000 0000


		for(int i =0;i<16;i++){
			if(i%3==0)
				b1.set(i); //Sets it to 1
			if(i%4==0)
				b2.set(i);
		}


		System.out.println(b1); //1001 0010 0100 1001
		System.out.println(b2); //1000 1000 1000 1000

		//This does intersection
		//b1.and(b2); //1000 0000 0000 1000

		//This does Union
		//b1.or(b2); //1001 1010 1100 1001

		//This does Union-Intersection
		b1.xor(b2); //0001 1010 1100 0001
		System.out.println(b1);






	}


}