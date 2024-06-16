package Model;

import java.sql.SQLException;
import java.sql.Statement; 
 
public class AddRecord { 
     
    Statement stmt; 
     
public void Form(String name, String address, String gender, String age,String fnum,String sp,String cnt) { 
        try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate 
("INSERT INTO patient VALUES('"+name+"', '"+address+"', '"+gender+"', '"+age+"', '"+fnum+"', '"+sp+"','"+cnt+"')"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
}
public void Staff(String id,String name, String address, String gender, String age,String sp,String cnt) { 
        try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate 
("INSERT INTO staff VALUES('"+id+"','"+name+"', '"+address+"', '"+gender+"', '"+age+"',  '"+sp+"','"+cnt+"')"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
}
public void addlogin(String id, String name, String pass,String type ) { 
        try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate 
("INSERT INTO login VALUES('"+id+"','"+name+"', '"+pass+"', '"+type+"')"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
}

public void Addmisson(String num, String name, String address, String gender, String age,String bed,String cnt,String date,String time) { 
        try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate 
("INSERT INTO addmission VALUES('"+num+"','"+name+"', '"+address+"', '"+gender+"', '"+age+"', '"+bed+"','"+cnt+"','"+date+"','"+time+"')"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
}
public void beds(String num, String name,String bed) { 
        try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate ("UPDATE `beds` SET `fnum`='"+num+"',`pname`='"+name+"' WHERE `bednumber`= '"+bed+"' "); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
}
  public void  medicine(String name,String beds,String des,String age) { 
        try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate
        ("INSERT INTO addedMedicine VALUES('"+name+"', '"+beds+"', '"+des+"', '"+age+"')"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    }
   public void  scan(String name,String beds,String des,String age) { 
        try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate
        ("INSERT INTO addscan VALUES('"+name+"', '"+beds+"', '"+des+"', '"+age+"')"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
    }
   public void donemedicine(String des){
              try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate
        ("DELETE FROM `addedmedicine` WHERE `bednumber`= '"+des+"'"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
   }
    public void donescan(String des){
              try { 
stmt = DBConnection.getStatementConnection(); 
stmt.executeUpdate
        ("DELETE FROM `addscan` WHERE `bednumber`= '"+des+"'"); 
        } catch (SQLException e) { 
            e.printStackTrace(); 
        } 
   }
}