/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursepro2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sohit
 */
public class UserInfo {
    
public String[] MyProfile_info(String uname){
    String arr[] = new String[3];
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM user");;
           ResultSet rs =ps.executeQuery();        
           while(rs.next())
                {
                String username = rs.getString("username");
                if(username.equals(uname)){
                    String dob = rs.getString("dob");
                    String sex = rs.getString("sex");
                    String email = rs.getString("email");  
                    arr[0]=dob;arr[1]=sex;arr[2]=email;
                }
                }
            } catch (SQLException ex) {
              Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
          }
         return arr;
    }
    
}
