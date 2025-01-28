import java.util.*;


class Student{
	int rollNo;
	String name;
	int standard;

	public Student(int rn,String n,int s)
	{	
		rollNo=rn;
		name=n;
		standard=s;
			
	}

	public String toString(){
		System.out.println("Roll No: " + rollNo);
		System.out.println("Name: "+name);
		System.out.println("Standard: "+standard);
		return "";
	}

	public boolean equals(Object obj){
		Student s = (Student) obj;
		if((this.rollNo == s.rollNo) && (this.standard == s.standard))
			return true;
		else
			return false;
	
	}

	public int hashCode()
	{
		/*
			This hashcode is used for creating buckets, which are used to better searching and sorting. So directly returning rollNo, would create too many buckets.
So we need to return standard, so that we can get "standard-wise sorting"
		*/
		return standard;
	}	

	//Overiding the compareTo() of comparable, to decide what we are going to compare on. We can use the compareTo() method for each datatype(String,Integer,Double) inside our custom method to sort the elements for every datatype acc to what is used in the TreeSet.
	public int compareTo(Object obj){
		Student s  = (Student) obj;
		//Yaha this is not used because it is a part of the same Class and rollNo is not directly accessible for this instance.
		return new Integer(rollNo).compareTo(s.rollNo);
		/*
		FOR REVERSE ORDER
		return new Integer (rollNo).compareTo(s.rollNo) * -1;
		*/
	}
}



/*
This class is a custom comparator, which can be used to compare two Student Objects based on their names. Since the Student class does not have a natural ordering (i.e. the Comparable interface is not implemented), we use this custom comparator to sort the Student objects in the TreeSet based on their names.

The compare() method is overridden to return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
*/
class NameSorter implements Comparator<Student>
{
	public int compare(Student s1, Student s2){
		return s1.name.compareTo(s2.name);
	}

}

/**
 * This class is a custom comparator, which can be used to compare two Student Objects based on their roll numbers.
 * The compare() method is overridden to return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
*/
class RollNoSorter implements Comparator<Student>
{
	public int compare(Student s1, Student s2){
		return new Integer (s1.rollNo).compareTo(s2.rollNo);
	}

}


class StandardSorter implements Comparator<Student>
{
	public int compare(Student s1, Student s2){
		return new Integer (s1.standard).compareTo(s2.standard);
	}

}


public class StudentList{
	public static void main(String args[]){
		//HashSet hs = new HashSet();
		TreeSet hs = new TreeSet(new NameSorter());
		/*
		TreeSet directly uses compareTo() method to sort out the elements in an Binary Tree. So we cannot override hashCode() and equals(). So we need to implement compareTo() from Comparable interface.
		*/

		hs.add(new Student(11,"Sanat",5));
		hs.add(new Student(22,"Madyy",6));
		hs.add(new Student(33,"Pusu",7));
		hs.add(new Student(44,"Sumit",8));
		hs.add(new Student(55,"Kadu",9));
		hs.add(new Student(66,"Daga",6));

		hs.add(new Student(66,"Daga",6));
		//It will allow duplicates since it does not check the contents of the objects.	


		Iterator i = hs.iterator();
		while(i.hasNext()){
			System.out.println(i.next());

		}
	}
}