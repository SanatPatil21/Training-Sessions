import java.io.*;
// This class is used to deserialize the Person object from the file named "person.ser".
public class Deserializing{

	public static void main(String args[])throws Exception{
		// Create an ObjectInputStream to read the object from the file.
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));

		// Read the object from the file.
		//The .class file must be the same that Serializing.java used, since Deserializing.java comapres the SUID(Uinuqe ID).
		Person obj = (Person) ois.readObject();
		// Print the age and name of the person.
		System.out.println("Age: "+obj.age);
		System.out.println("Name: "+obj.name);
	}
}

