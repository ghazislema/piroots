/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://www.google.com/settings/security/lesssecureapps
 */

package util;

/**
 *
 * @author Naveen
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSend {

    public static String host ="smtp.gmail.com" ;
    public static String user = "ghazi.slema@esprit.tn";
    public static String pass = "183JMT0137";
    public static String to = "ghazi_slema@outlook.fr";
    public static String from = "ghazi.slema@esprit.tn";
    public static String username="";
    public static String tripid="";
    public static void main(String args[]){
        try{
            
            String subject ="Smart Roots notification";
            String messageText = "Hello, "+username+" \n\n\n"
                    + "Unfortunately your trip reservation #"+tripid+" has been cancelled. Please contact our"
                    + "support at Roots@support.tn for more details.\n\n\n"
                    + "Best regards";
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
}
