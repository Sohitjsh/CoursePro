/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursepro2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sohit
 */
public class EditProfileInfo {
    
    public void UpdateInfo(String dob,String sex,String email){
         String username = HomeWindow.uname;
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         
            try 
               {

                   ps = con.prepareStatement("UPDATE `user` SET dob = ?, sex = ?, email = ? WHERE `username` = ?");
                   ps.setString(1, dob);
                   ps.setString(2, sex);
                   ps.setString(3,email);
                   ps.setString(4, username);

                   
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, " Chnages Saved! ");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
                }
      }
    
    public void ChangePassword(String password){
        
         String username = HomeWindow.uname;
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         
            try 
               {

                   ps = con.prepareStatement("UPDATE `user` SET password = ? WHERE `username` = ?");
                   ps.setString(1, password);
                   ps.setString(2, username);

                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, " Password Changed");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
                }
    }
}
