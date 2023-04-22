/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursepro2;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author sohit
 */
public class User {
    
    private final MessageDigest md;
      public User() throws SecurityException {
    try {
      md = MessageDigest.getInstance("MD5", "SUN");
    }catch(NoSuchAlgorithmException | NoSuchProviderException se) {
      throw new SecurityException("In MD5 constructor " + se);
    }
  }
       
      public void insertUser(String username,String password,String dob,String sex,String email){
         
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         
            try 
               {
                   ps = con.prepareStatement("INSERT INTO user(username,password,dob,sex,email) VALUES (?,?,?,?,?)");
                   ps.setString(1, username);
                   ps.setString(2, password);  
                   ps.setString(3, dob);
                   ps.setString(4, sex);
                   ps.setString(5,email);
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "New User Added");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
                }
      }    
      
      public boolean isUserExist(String userName){
           boolean isExist= false;
             Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM `user` WHERE `username` = ?");
           ps.setString(1,userName);
           ResultSet rs =ps.executeQuery();        
         
           if(rs.next())
                {
               isExist= true;
                }
            } catch (SQLException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
          }
           return isExist;
       
       }

       public static String getMD5Hash(String s) throws NoSuchAlgorithmException {

            String result = s;
            if (s != null) {
                MessageDigest md = MessageDigest.getInstance("MD5"); // or "SHA-1"
                md.update(s.getBytes());
                BigInteger hash = new BigInteger(1, md.digest());
                result = hash.toString(16);
                while (result.length() < 32) { // 40 for SHA-1
                    result = "0" + result;
                }
            }
            return result;
        }
       
       public void deleteUser(String username){
           Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
             int yesORno=JOptionPane.showConfirmDialog(null, " Delete Account? ","Delete Account",JOptionPane.OK_CANCEL_OPTION,0);
             if(yesORno == 0){
               try 
               {
                   ps = con.prepareStatement("DELETE FROM `user` WHERE `username`= ?");
                   ps.setString(1, username);
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "Account Deleted");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
                }
             }
       }

}
