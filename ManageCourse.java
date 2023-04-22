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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sohit
 */
public class ManageCourse {
    
    public void Fill_MyCourse_Table(JTable table,int ID){                       //Fills the MyCourse Table w/t Name & Link
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM courses");;
           ResultSet rs =ps.executeQuery();        
           while(rs.next())
                {
                int id = rs.getInt("id");
                if(id==ID){
//                    String id = String.valueOf(rs.getInt("id"));
                    String name = rs.getString("name");
                    String link = rs.getString("link");
                    
                
                    String tbData[] = {name,link};
                    DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
                    tblModel.addRow(tbData);
                    
                }
                }
            } catch (SQLException ex) {
              Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public void Fill_courseID_Table(JTable table,int ID){                       //Old Function : Not in USE
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM user");;
           ResultSet rs =ps.executeQuery();        
           while(rs.next())
                {
                int id = rs.getInt("id");
                if(id==ID){
//                    String id = String.valueOf(rs.getInt("id"));
                    String courseID = rs.getString("courseID");
//                    String link = rs.getString("link");
                    
                
                    String tbData[] = {courseID};
                    DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
                    tblModel.addRow(tbData);
                    
                }
                }
            } catch (SQLException ex) {
              Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    public void Fill_Student_Table(JTable table){                               //Fills the BrowseCourse Table
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM courses");;
           ResultSet rs =ps.executeQuery();        
           while(rs.next())
                {
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String length = rs.getString("length");
                String cost = rs.getString("cost");
                String by = rs.getString("Created by-");
                
                String tbData[] = {id,name,length,cost,by};
                DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
                tblModel.addRow(tbData);
                
                
                }
            } catch (SQLException ex) {
              Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
          }
}
    

    public String Fill_courseID_Label(String uname){                            //Fills the Label with user CourseID
        String courseID="";
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM user");;
           ResultSet rs =ps.executeQuery();        
           while(rs.next())
                {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                if(username.equals(uname)){
                    courseID = rs.getString("courseID");
                }
                }
            } catch (SQLException ex) {
              Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
          }
         return courseID;
    }

    
    public void Fill_courseID_Table(JTable table,String courseID){              //Fills The CourseID & name Table
               
        int courseid = Integer.parseInt(courseID);
         Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps;
         try{
           ps = con.prepareStatement("SELECT * FROM courses");;
           ResultSet rs =ps.executeQuery();        
           while(rs.next())
                {
                int id = rs.getInt("id");
                if(id==courseid){
                    String name = rs.getString("name");

                    String tbData[] = {courseID,name};
                    DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
                    tblModel.addRow(tbData);
                    
                    
                }
                }
            } catch (SQLException ex) {
              Logger.getLogger(ManageCourse.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
   
}
