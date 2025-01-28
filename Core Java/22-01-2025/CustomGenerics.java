class A<X>{
	public void add(X a, X 	b){
		System.out.println("Generic Logic........");
		
	}
	
}


public class CustomGenerics{
	public static void main(String args[]){
		A<String> a1 = new A<String>();
		a1.add("10","20");


		A<Integer> a2 = new A<Integer>();
		a2.add(10,20);

		A<Double> a3 = new A<Double>();
		a3.add(10.7,20.3);
	}
	
}