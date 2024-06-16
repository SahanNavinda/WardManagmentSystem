/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.SQLException;
import java.sql.Statement; 
 
/**
 *
 * @author Lap.lk
 */
public class Delete {
  Statement stmt; 

public void deletepatient(String fnum){
              try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate
        ("DELETE FROM `patient` WHERE `File_Number`= '"+fnum+"'"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
   }  
public void deletestaff(String id){
              try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate
        ("DELETE FROM `staff` WHERE `Staff_id`= '"+id+"'"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
   }  
}
