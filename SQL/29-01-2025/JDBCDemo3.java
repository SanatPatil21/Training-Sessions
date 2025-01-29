import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo3 {
    
    public static void main(String args[])
	{
		try
		{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");

            //This type of statement is used to call stored procedures in the database 
            CallableStatement cstmt = con.prepareCall("CALL dummy_record()");
            cstmt.execute();

			cstmt.close();
			con.close();
			

		}catch(Exception e){
			System.out.println(e);
	
		}

	}


}
