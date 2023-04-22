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
public class InsertCourse {
    
    public void insertCourseID(String courseID,String username){
         
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         
            try 
               {

                   ps = con.prepareStatement("UPDATE `user` SET `courseID`= ? WHERE `username` = ?");
                   ps.setString(1, courseID);
                   ps.setString(2, username);

                   
                   
                    if(ps.executeUpdate() > 0){
                       JOptionPane.showMessageDialog(null, "Course Added!");
                     }
                } 
            catch (SQLException ex) 
                {
                     Logger.getLogger(User.class.getName()).log(Level.SEVERE,null,ex);
                }
      }
}
