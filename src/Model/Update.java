/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Lap.lk
 */
public class Update {
     Statement stmt;
     
    
    
    public void updatepatient(String name, String address, String gender, String age,String fnum,String sp,String contact) { 
        try { 
    stmt = DBConnection.getStatementConnection(); 
    stmt.executeUpdate 
        ("UPDATE `patient` SET `Name`='"+name+"',`Address`='"+address+"', `Gender`='"+gender+"', `Age`='"+age+"', `Special`='"+sp+"',`Contact`='"+contact+"'  WHERE File_Number='"+fnum+"'"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
}
       public void updatestaff(String id,String name, String address, String gender, String age,String type,String contact) { 
        try { 
    stmt = DBConnection.getStatementConnection(); 
    stmt.executeUpdate 
        
        ("UPDATE `staff` SET `Name`='"+name+"',`Address`='"+address+"', `Gender`='"+gender+"', `age`='"+age+"', `Staff_type`='"+type+"',`Contact`='"+contact+"' WHERE Staff_id='"+id+"' "); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
}
       
        
    }

