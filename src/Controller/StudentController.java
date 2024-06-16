package Controller;

import javax.swing.JOptionPane; 
import Model.AddRecord;

 
public class StudentController { 
     
public static void Form(String name, String address, String gender, String age,String fnum,String sp,String cnt) { 
    new Model.AddRecord().Form(name, address, gender, age, fnum,sp,cnt); 
        JOptionPane.showMessageDialog(null, "New Record has been inserted", "Successfull", 
JOptionPane.INFORMATION_MESSAGE); 
}   
public static void staff(String ID,String name, String address, String gender, String age,String Stafftype,String cnt) { 
    new Model.AddRecord().Staff(ID,name, address, gender, age,Stafftype,cnt); 
        JOptionPane.showMessageDialog(null, "New Record has been inserted", "Successfull", 
JOptionPane.INFORMATION_MESSAGE); 
}   
     


     
public static void Addmission (String fnum,String name, String address, String gender, String age,String bed, String cnt,String date,String time) { 
    new Model.AddRecord(). Addmisson(fnum, name, address, gender, age, bed,cnt,date,time); 
        JOptionPane.showMessageDialog(null, "New Record has been inserted", "Successfull", JOptionPane.INFORMATION_MESSAGE); 
}  
public static void beds(String fnum,String name,String beds) { 
    new Model.AddRecord(). beds(fnum, name,beds); 
        
}   
   public static void  medicine(String name,String beds,String des,String age){
       new Model.AddRecord(). medicine( name,beds,des,age); 
   }
     public static void  scan(String name,String beds,String des,String age){
       new Model.AddRecord(). scan(name,beds,des,age); 
   }
    public static void  donemedicine (String des){
        new Model.AddRecord().donemedicine(des);
    }
     public static void  donescan (String des){
        new Model.AddRecord().donescan(des);
    }
    
    public static void updatepatient(String name, String address, String gender, String age,String fnum,String sp,String contact){
        new Model.Update().updatepatient(name, address, gender, age, fnum,sp,contact); 
        JOptionPane.showMessageDialog(null, "New Record has been Updated", "Successfull", 
JOptionPane.INFORMATION_MESSAGE); 
    }
     public static void updatestaff(String id,String name, String address, String gender, String age,String type,String contact){
        new Model.Update().updatestaff(id,name, address, gender, age, type,contact); 
        JOptionPane.showMessageDialog(null, "New Record has been Updated", "Successfull", 
JOptionPane.INFORMATION_MESSAGE); 
    }
    public static void deletepatient(String fnum){
        new Model.Delete().deletepatient(fnum); 
        JOptionPane.showMessageDialog(null, "New Record has been Deleted", "Successfull", 
JOptionPane.INFORMATION_MESSAGE); 
    }
     public static void deletestaff(String id){
        new Model.Delete().deletestaff(id); 
        JOptionPane.showMessageDialog(null, "New Record has been Deleted", "Successfull", 
JOptionPane.INFORMATION_MESSAGE); 
    }
}
