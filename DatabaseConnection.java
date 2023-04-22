/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursepro2;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sohit
 */
public class DatabaseConnection {
       public static Connection getConnection()
    {
        String url = "jdbc:mysql://127.0.0.1:4306/coursepro";
        String user = "root";     
        String password = "";
        Connection con = null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(url,user,password);
          } catch(Exception ex){
            System.out.println(ex);
          }
           return con;
    }
   
}
