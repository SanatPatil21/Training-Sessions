import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;


import javax.xml.transform.Result;

public class JDBC2Demo
{
	public static void main(String args[])
	{
		try
		{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");

			PreparedStatement pstmt = con.prepareStatement("insert into EMPLOYEE2 values(?, ?)");
			System.out.println("Enter name: ");
			String name = br.readLine();
			System.out.println("Enter age: ");
			int age = Integer.parseInt(br.readLine());

			pstmt.setString(1, name);
			pstmt.setInt(2,age);
			//These 1 and 2 are the indexes pointing to the Question Marks in the PreparedStatement

			pstmt.execute();
			//pstmt.executeUpdate();

			/*
			Both do the same work, BUT execute returns a boolean like sucessfull or not, WHEREAS executeUpdate() will return a int which will show how many rows or columns are affected by this statement.(Mostly used in the case of "delete" query)
			*/

			


			pstmt.close();
			con.close();
			

		}catch(Exception e){
			System.out.println(e);
	
		}

	}



}