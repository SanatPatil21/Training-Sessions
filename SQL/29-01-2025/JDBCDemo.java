import java.sql.*;
import java.util.*;


import javax.xml.transform.Result;

public class JDBCDemo
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");

			Statement stmt = con.createStatement();
			System.out.println("Enter name: ");
			String name = new Scanner(System.in).nextLine();
			System.out.println("Enter age: ");
			int age = new Scanner(System.in).nextInt();

			stmt.executeUpdate("insert into EMPLOYEE2 values('"+name+"',"+age+")");

			//stmt.executeUpdate("update EMPLOYEE2 set AGE=AGE+1");
			//stmt.executeUpdate("delete from EMPLOYEE2 where AGE<30");


			ResultSet rs = stmt.executeQuery("select * from EMPLOYEE2");
			while(rs.next()){
				System.out.println("Name: "+rs.getString(1));
				System.out.println("Age: "+rs.getInt("AGE"));
			}


			rs.close();
			stmt.close();
			con.close();
			

		}catch(Exception e){
			System.out.println(e);
	
		}

	}



}