/*
	Functional Interface:- A interface of which only one method must be implemented. Since methods of Object class are be default implemented, they are already implemented
*/
@FunctionalInterface
interface I {
	public void abc();

	public boolean equals(Object o);

	public int hashCode();
}

class A implements I {
	public void abc() {
		System.out.println("From A class abc() method");
	}

}

class B {
	public void demo() {
		System.out.println("Hi bacchilog!!");
	}

}

public class FunctionalInterfaceDemo {
	public static void main(String args[]) {
		/*

		// Anonymous Class, creates a FunctionalInterfaceDemo$1.class file
		I i2 = new I() {
			public void abc() {
				System.out.println("From I interface abc() method");
			}
		};
		i2.abc();

		B b1 = new B() {
			public void demo() {
				System.out.println("Anonymous class of B");
			}

		};
		b1.demo();

		*/

		I i3 = () -> System.out.println("From lambda Expression");
		i3.abc();
	}

}