import java.sql.*;

public class ResultSetDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from employee2");
        
        // Iterate through the ResultSet in the forward direction
        while (rs.next()) {
            System.out.println("Name: " + rs.getString(1));
            System.out.println("Age: " + rs.getInt(2));
        }
        
        System.out.println("------------------");

        // Move the cursor to the end of the ResultSet and iterate backward
        // rs.afterLast(); 
        while(rs.previous()){
            System.out.println("Name: " + rs.getString(1));
            System.out.println("Age: " + rs.getInt(2));
        }
        
        System.out.println("------------------");

        // Move the cursor to the third row of the ResultSet
        rs.absolute(3);
        System.out.println("Name: " + rs.getString(1));
        System.out.println("Age: " + rs.getInt(2));

        // Move the cursor two rows forward from the current position
        rs.relative(2);
        System.out.println("Name: " + rs.getString(1));
        System.out.println("Age: " + rs.getInt(2));

        /*
            Additional ResultSet navigation methods:
            rs.last()  -> Moves the cursor to the last row
            rs.isLast()  -> Checks if the cursor is on the last row
            rs.first()  -> Moves the cursor to the first row
            rs.isFirst()  -> Checks if the cursor is on the first row
            rs.beforeFirst() -> Moves the cursor to a position before the first row
            rs.isBeforeFirst() -> Checks if the cursor is before the first row
            rs.afterLast() -> Moves the cursor to a position after the last row
            rs.isAfterLast() -> Checks if the cursor is after the last row
         */

        // Close the ResultSet and Statement to release database resources
        rs.close();
        stmt.close();

        // Close the database connection
        con.close();
    }
}