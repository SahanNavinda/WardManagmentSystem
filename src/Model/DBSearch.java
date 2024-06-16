package Model;

import Model.DBConnection;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.PreparedStatement;

public class DBSearch { 
Statement stmt; 
ResultSet rs; 
public ResultSet searchLogin(String usName,String type) { 
try { 
stmt = DBConnection.getStatementConnection(); 
String name = usName; 
String typ = type;
//Execute the Query 

rs = stmt.executeQuery("SELECT * FROM login where username='" + name + "'"); 

} catch (Exception e) { 
e.printStackTrace(); 
} 
return rs; 
} 
public ResultSet searchpatient(String fName){ 
try{ 

            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM patient WHERE File_Number= '"+fName+"' ");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return rs;
        }
public ResultSet searchstaff(String id){ 
try{ 

            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM Staff WHERE Staff_id= '"+id+"' ");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return rs;
        }
 public ResultSet searchaddmission(String fName){ 
try{ 

            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM addmission WHERE num= '"+fName+"' ");
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return rs;
        }
               
        public ResultSet searchlecture(String lecID){
            
            try {
                
                 Class.forName("com.mysql.cj.jdbc.Driver");
            
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM lecturer WHERE lecturer_id = '"+lecID+"' ");
              
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return rs;
            
        }
        
         public ResultSet searchAllmedi(){
            
            try {
                
                 Class.forName("com.mysql.cj.jdbc.Driver");
            
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM addedmedicine ");
              
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return rs;
            
        }
        
         
          public ResultSet searchAllCourseDetails(){
            
            try {
                
                 Class.forName("com.mysql.cj.jdbc.Driver");
            
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM course ");
              
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return rs;
            
        }
          
public ResultSet searchAll(){
            
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM patient");
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
            return rs;
        }
    public ResultSet meditbl(){
            
            try {
                
                 Class.forName("com.mysql.cj.jdbc.Driver");
            
            stmt = DBConnection.getStatementConnection();
            rs = stmt.executeQuery("SELECT * FROM lecturer ");
              
                
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return rs;
            
        }
       
} 