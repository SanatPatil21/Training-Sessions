import javax.sql.*;
import javax.sql.rowset.*;

class MyListener implements RowSetListener{
	public void cursorMoved(RowSetEvent evt){
		System.out.println("----CURSOR MOVED------");
	}
}


public class RowSetDemo{

	public static void main(String args[]){

	try{
		RowSetFactory rsf = RowSetProvider.newFactory();
		JdbcRowSet rs = rsf.createJdbcRowSet();

		rs.setUrl("jdbc:postgresql://localhost:5432/postgres");
		rs.setUsername("postgres");
		rs.setPassword("tiger");


		rs.setCommand("select * from EMP");

		rs.execute();

		while(rs.next()){
			System.out.println("\nEID: "+rs.getInt(1));
			System.out.println("Name: "+rs.getString(2));
			System.out.println("Age: "+rs.getInt(3));
			System.out.println("Salary: "+rs.getDouble(4));
			System.out.println("Designation: "+rs.getString(5));
		}

		rs.close();
		
	
	


	}catch(Exception e)
	{
		System.out.println(e);
	}

	}


}