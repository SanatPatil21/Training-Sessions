import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionDemo {
    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "tiger");
                
            con.setAutoCommit(false);
            //be def, auto commit is set to true
            
            PreparedStatement pstmt = con.prepareStatement("insert into EMPLOYEE2 values(?, ?)");

            for (int i = 0; i <= 5; i++) {
                System.out.println("Enter name: ");
                String name = br.readLine();
                System.out.println("Enter age: ");
                int age = Integer.parseInt(br.readLine());

                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.execute();

                if(i==5)
                    con.rollback();
                if(i==10)
                    con.commit();

            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

}
