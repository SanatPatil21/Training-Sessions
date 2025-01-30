import java.io.*;
import java.sql.*;

public class ReadFromTable{
    public static void main(String[] args){
        try {
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter table name: ");
            String table = br.readLine();

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "tiger");
            Statement stmt = con.createStatement();

            /*
             This code demonstrate how we can dynamically get the details from the any table  
             */
            ResultSet rs = stmt.executeQuery("select * from "+table);
            //This will fetch any table which is passed dynamically

            //This gets all of the MetaData from the Table whose result set we have taken
            ResultSetMetaData rsmd = rs.getMetaData();
            
            //This can give us the number of columns in that table
            int columns = rsmd.getColumnCount();
            
            while(rs.next()){
                //We can iterate on these columns to get all of the data
                for (int i = 1; i <= columns; i++) {
                    //getColumnName() will get us the name of the column using the column number
                    System.out.println(rsmd.getColumnName(i).toUpperCase()+" : "+rs.getString(i));
                }
                System.out.println();
    
            }
            rs.close();
            stmt.close();
            con.close();
            

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}