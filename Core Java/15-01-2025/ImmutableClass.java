import java.io.Serializable;
/* 
final class Student implements Serializable{
	private final int rollNo;
	private final String name;
	private final int standard;

	public Student(int rn, String n, int s)
	{
		rollNo=rn;
		name=n; 
		standard=s;
	}
	public int getRollNo(){
		return rollNo;

	}
	public String getName(){
		return name;

	}
	public int getStandard(){
		return standard;
	}

	//This is default method which is always called when we write println, so if we overrride this method we can add custom "by default" code.
	public String toString(){
		return "Student[Roll No : "+rollNo+", Name: "+name+",Standard: "+standard+"]";
	}

	//override this hashcode method to use the roll no as the unique identifier.
	public int hashCode(){
		return rollNo;
	}

	public boolean equals(Object obj){
		Student s1 = (Student) obj;
		if((this.rollNo==s1.rollNo) && (this.name.equals(s1.name)) && (this.standard==s1.standard))
			return true;
		else
			return false;
	}

}
*/

//This replaces all the lines of codes we wrote above. So it basically allows for an easier way to create a "Custom Immutable Class".
//The constructor here is known as "Cannonical Constructor"

/* record Student(int rollNo, String name, int standard){}; */



//If we suppose want our own custom constructor
record Student(int rollNo, String name, int standard,String city ){
	static String schoolName;

	//Since default CC wont handle the case when "city" argument is not passed, this user defined const is defined which calls the CC using "this(....)"
	Student(int rollNo, String name, int standard){
		this(rollNo, name, standard, null);
	}

	//Overiding the cannonical constructor to add exception handling
	Student(int rollNo, String name, int standard,String city){
		this.name=name;
		if (rollNo < 0) {
            throw new IllegalArgumentException("Roll No cannot be negative");
        }
		this.rollNo=rollNo;
		this.standard=standard;
		this.city=city;

	}

	public void display(){
		System.out.println("Demo printing");
	}

	public boolean equals(Object obj){
		Student s1 = (Student) obj;
		if((this.rollNo==s1.rollNo) && (this.name.equals(s1.name)) && (this.standard==s1.standard))
			return true;
		else
			return false;
	}

	
}



public class ImmutableClass{
    public static void main(String args[]){
	Student s1 = new Student(11,"Rinku",5);

	Student s2 = new Student(12,"Rinku",5);

	System.out.println(s1);
	System.out.println(s2);

	System.out.println(s1.hashCode());
	System.out.println(s2.hashCode());

	System.out.println(s1.equals(s2));

        
    }

}