package Controller;

import View.Home; 
import Model.DBConnection; 
import Model.DBSearch; 
import java.awt.Frame; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import javax.swing.JOptionPane; 
import View.DrLogin;
import View.AddMedicine;
import View.DrPage;
import View.NrLogin;
import View.ToMedicine;
import View.NursePage;
import View.ToScan;
public class LoginController { 
public static void login(String usName, String pass,String type) { 
try { 
String username = null; // initial value of the username 
String password = null; 
String typ= null;// initial value of the password 
ResultSet rs = new DBSearch().searchLogin(usName,type); 
//Process the Query 
while (rs.next()) { 
username = rs.getString("username"); //assign database login name to the variable
        password = rs.getString("password");
        typ= rs.getString("Stafftype");//assign database password to the variable 
            } 
            if (username != null && password != null) { 
                if (password.equals(pass)) { 
         System.out.println("Login Successfull"); 
         if ("Doctor".equals(typ)){
             JOptionPane.showMessageDialog(null, "You are Login as a Doctor", "Welcome Doctor", JOptionPane.INFORMATION_MESSAGE); 
         DrLogin.getFrames()[0].dispose(); 
         new DrPage().setVisible(true);} 
         else if("Nurse".equals(typ)){
             JOptionPane.showMessageDialog(null, "You are Login as a Nurse", "Welcome Nurse", JOptionPane.INFORMATION_MESSAGE); 
                  DrLogin.getFrames()[0].dispose(); 
         new NursePage().setVisible(true);
                 }
         else if("Attendee".equals(typ)){
             JOptionPane.showMessageDialog(null, "You are Login as a Attendee", "Welcome Nurse", JOptionPane.INFORMATION_MESSAGE); 
                  DrLogin.getFrames()[0].dispose(); 
         new ToScan().setVisible(true);
                 }
         else { 
             JOptionPane.showMessageDialog(null, "Please check the credentials", "Error", JOptionPane.ERROR_MESSAGE); 
         }
         
         
                } else { 
JOptionPane.showMessageDialog(null, "Please check the credentials", "Error", JOptionPane.ERROR_MESSAGE); 
                } 
            } else { 
JOptionPane.showMessageDialog(null, "Please check the Credentials", "Error", JOptionPane.ERROR_MESSAGE); 
            } 
            DBConnection.closeCon(); 
        } catch (SQLException ex) {        
Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    }
public static void addlogin(String ID,String name, String pass,String type) { 
    new Model.AddRecord().addlogin(ID,name, pass,type); 
        
}

} 