import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
//import java.lang.ClassNotFoundException; //This is not necessary since java.lang is automatically imported on all java programs.

public class JDBC {

    final static String DRIVER = "org.mariadb.jdbc.Driver";
    final static String DBURL = "jdbc:mariadb://127.0.0.1:3306/studentsystem";
    final static String USER="root";
    final static String KEY = "Ud415zAs";

    private Connection conn;
    private Statement stmt;


    //method to connect to the database
    public Connection connection(){

        try{
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL,USER,KEY);
            stmt = conn.createStatement();


            return conn;
        }

        catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }




public void exeQuery(String query){
    connection();
    try {
        ResultSet rst= stmt.executeQuery(query);
        // Process the result set
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,e);
    }
}

}
