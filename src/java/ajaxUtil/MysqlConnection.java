/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajaxUtil;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pol
 */
public final class MysqlConnection {
    private static Connection connection = null;
    private static MysqlConnection instance = null;
    
    private MysqlConnection() throws ClassNotFoundException{
        performConnection();
    }
    
    private synchronized static void createInstance() throws ClassNotFoundException{
        if(instance == null){
            instance = new MysqlConnection();
        } 
    }
    
    public static MysqlConnection getInstance() throws ClassNotFoundException{
        if(instance == null){
            createInstance();
        }
        return instance;
    }
    
    public static void deleteInstance(){
        instance = null;
        closeConnection();
    }
    
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/login1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "champion";
    private static final String MAX_POOL = "250";
    
    

    public void performConnection() throws ClassNotFoundException {
        try{
            Class.forName(DATABASE_DRIVER);
            String connUrl = DATABASE_URL + "?user=" + USERNAME + "&password=" + PASSWORD;
            connection = (Connection) DriverManager.getConnection(connUrl);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Error when open conn");
        }
    }
    
     private static void closeConnection() {
         try{
             connection.close();
         } catch(Exception e){
             System.out.println("Error when close conn");
         }
    }
    
}
 
    
    

