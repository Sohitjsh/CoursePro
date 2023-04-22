/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursepro2;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sohit
 */
public class EmailSender {
    
     public void EmailSend(String ToEmail){

    String FromEmail = "courseprowelcome@gmail.com";
    String FromEmailPassword = "aldkpudvrocapvwm";
    String Subjects = " Welcome To CoursePro! ";
    String body = "Hello Dear, \n"
            + "                 we the minds behind CoursePro warmly Welcome & congratulate you in being the part of this Family with us";

    Properties p = new Properties();
    p.put("mail.smtp.auth","true");
    p.put("mail.smtp.starttls.enable","true");
    p.put("mail.smtp.host","smtp.gmail.com");
    p.put("mail.smtp.port","587");

    Session session = Session.getDefaultInstance(p,new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication(FromEmail, FromEmailPassword);
            }
    } );

    try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FromEmail));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(ToEmail));
            message.setSubject(Subjects);
            message.setText(body);
            Transport.send(message);

    }catch(Exception ex){
            System.out.println(""+ex);
    }
    
    }
    
   
}
