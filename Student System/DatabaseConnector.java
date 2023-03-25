import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
//import java.lang.ClassNotFoundException; //This is not necessary since java.lang is automatically imported on all java programs.

public class JDBC {
    
    final static String DRIVER = "org.mariadb.jdbc.driver";
    final static String DBURL = "jdbc:mariadb://localhost:3306/studentSystem";
    final static String USER="root";
    final static String KEY = "Ud415zAs";
    
    
    //method
    public static Connection connection(){
        
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(DBURL,USER,KEY);
            return conn;
        }
        
        catch(SQLException | ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
       
        
    }
            
    
}
