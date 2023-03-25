import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
//import java.lang.ClassNotFoundException; //This is not necessary since java.lang is automatically imported on all java programs.

public class JDBC {
    
    final static String DRIVER = "org.mariadb.jdbc.driver";
    final static String DBURL = "jdbc:mariadb://localhost:3306/task2";
    final static String USER="root";
    final static String KEY = "password";
    
    
    //method to connect to the database
    public Connection connection(){
        
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(DBURL,USER,KEY);
            Statement stmt = conn.createStatement(); 
            
     
            return conn;
        }
        
        catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
        



public void exeQuery(String query){
    connection();
    ResultSet rst= stmt.executeQuery(query);
    
}
    
}
