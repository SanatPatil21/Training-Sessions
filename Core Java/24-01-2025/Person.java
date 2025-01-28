class Person implements java.io.Serializable{
	String name;
	int age;
	//If we add 'transient' or 'static', that variable wont be serailized
	//Serializable is marker  interface, there are no methods to be implemented, it just marks this class as Serializable

}
