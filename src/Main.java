import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class RunSelectQuery {
    public static void main(String[] args) {
        try{

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url = "jdbc:mysql://localhost:3306/<your database name>";
            String username="****"; //write your username -> by default its "root"
            String password = "**************"; //write your password

            Connection con = DriverManager.getConnection(url, username, password);


            String q = "select * from table1;";

            Statement stmt = con.createStatement();
            ResultSet set =stmt.executeQuery(q);
            while(set.next()){
                System.out.println(set.getInt(1)+" : " +
                        set.getString(2)+" : "+set.getString(3));
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
