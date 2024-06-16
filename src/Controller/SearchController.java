/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Lenovo
 * 
 */
import Model.DBConnection;
import Model.DBSearch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import View.Home;
import javax.swing.JOptionPane;



public class SearchController {
    
    

    public static void search(String indexNum){
        
        try{
            
       String indexNumber = null;
       String type =null;
      
           
            ResultSet rs = new DBSearch().searchLogin(indexNum,type);
            
            while(rs.next()){
                
                  indexNumber= rs.getString("File_Number");
              
                     
            }

                if(indexNumber != null){
                       
                       if(indexNumber.equals(indexNum)){
                
                       }
                   
   
                   }
                   else{
                  //     JOptionPane.showMessageDialog(null, "Please Enter Valid Index Number", "Error", JOptionPane.ERROR_MESSAGE);
                   }
       
            
            DBConnection.closeCon();
        }
        catch(SQLException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    
}
