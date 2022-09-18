import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

class Main {

    public static void main(String[] args) {
        try{

            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //creating a connection
            String url = "jdbc:mysql://localhost:3306/vipuldb";
            String username="****"; //write your username
            String password = "**************"; //write your password

            Connection con = DriverManager.getConnection(url, username, password);


            //insert large image -> data type should be of longblob
            String q = "insert into images(pic) values(?)";

            PreparedStatement pstmt =  con.prepareStatement(q);

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);

            File file =jfc.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);

            pstmt.setBinaryStream(1, fis, fis.available());
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"image uploaded..");


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}