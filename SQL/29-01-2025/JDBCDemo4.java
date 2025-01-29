import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo4 {
    public static void main(String[] args) {
        try
		{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");

            //BATCH STATEMENTS
            Statement stmt = con.createStatement();

            stmt.addBatch("insert into EMPLOYEE2 values('Aman',25)");
            stmt.addBatch("insert into EMPLOYEE2 values('Babita',35)");
            stmt.addBatch("insert into EMPLOYEE2 values('Jethalal',45)");
            stmt.addBatch("insert into EMPLOYEE2 values('Surender',23)");
            stmt.addBatch("insert into EMPLOYEE2 values('Vijay',27)");
            stmt.addBatch("insert into EMPLOYEE2 values('Ajay',25)");
            
            System.out.println("Wait for 10 secs");
            Thread.sleep(10000);
            stmt.executeBatch();
            System.out.println("Comepleted");


			stmt.close();
			con.close();
			

		}catch(Exception e){
			System.out.println(e);
	
		}
    }
    
    
}
