/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.LoginController;
import Controller.SearchController;
import Controller.StudentController;
import Model.DBConnection;
import Model.DBSearch;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Lap.lk
 */
public class Admission extends javax.swing.JFrame {
    Connection con;
    ResultSet rs;
    PreparedStatement pst ;
    Statement stmt;
    
    
    public void currentDate (){
        
        Calendar cal =new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        
        lbl_date.setText((month+1)+"/"+day+"/"+year);
        lbl_date1.setText((month+1)+"/"+day+"/"+year);
        
        //Time
      
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        
        lbl_time.setText(hour+":"+(minute)+":"+second);
        lbl_time1.setText(hour+":"+(minute)+":"+second);
        
       
    }
   
    /**
     * Creates new form Admission
     */
    public Admission() {
        initComponents();
        currentDate ();
        add();
        this.setLocationRelativeTo(null);
    }
   public void add(){
       try{ stmt = DBConnection.getStatementConnection(); 
           
            rs=stmt.executeQuery("Select bednumber from beds where pname =''");
            while(rs.next()){
                combobed.addItem(rs.getString("bednumber"));
            }
   }
       catch(SQLException ex){ 
           Logger.getLogger(DBSearch.class.getName()).log(Level.SEVERE, null, ex);
           
} }
 /**  public void pdf(){
       String value = fileno.getText();
            String value0 = name.getText();
            String value1 = address.getText();
            String value2 = age.getText();
            
                                                      
            
            JFileChooser dialog = new JFileChooser();
            dialog.setSelectedFile(new File(value +" "+ value0+"Addmission"+".pdf"));
            int dialogResult = dialog.showSaveDialog(null);
            if (dialogResult==JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
           
        try {
            // TODO add your handling code here:
            
            
        String sql ="select * from Deductions where emp_id = '"+value1+"'";
            pst=(PreparedStatement) con.prepareStatement(sql);
            rs=pst.executeQuery(); 
            String val = rs.getString(5);
            String reason = rs.getString(6);
            rs.close();
            pst.close();
          
            String sq ="select * from pateint where File_Number = '"+value1+"'";
           pst=(PreparedStatement) con.prepareStatement(sq);
            rs=pst.executeQuery(); 
            
           
       
         
           
           Document myDocument = new Document();
           PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
           myDocument.open();
           
           myDocument.add(new Paragraph("PAY SLIP",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
           myDocument.add(new Paragraph(new Date().toString()));
           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
           myDocument.add((new Paragraph("EMPLOYEE DETAILS",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD))));
           myDocument.add((new Paragraph("Name of Employee: " +value + " "+value0,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
           myDocument.add((new Paragraph("Designation: "+value2,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
          
           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
           myDocument.add(new Paragraph("SALARY",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
       
           myDocument.add(new Paragraph("Overtime: "+rs.getString(2)+" Hours",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
           myDocument.add(new Paragraph("Medical: $" +rs.getString(3),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
           myDocument.add(new Paragraph("Bonus: $"+rs.getString(4),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
           myDocument.add(new Paragraph("Other: $"+rs.getString(5),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
           myDocument.add(new Paragraph("DEDUCTION",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
           myDocument.add(new Paragraph("Deduction Details: "+reason,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
           myDocument.add(new Paragraph("Total Deductions : $"+val ,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
           myDocument.add(new Paragraph("TOTAL PAYMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
           myDocument.add(new Paragraph("Total Earnings: "+rs.getString(9),FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
          
           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
           
           
           myDocument.newPage();
           myDocument.close();  
           JOptionPane.showMessageDialog(null,"Report was successfully generated");
           
     }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
         
     }
     finally {
            
            try{
               rs.close();
               pst.close();
                
            }
            catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
         
            }
     }
   }
        
   }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        contactTF = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        fileno = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lbl_time1 = new javax.swing.JTextField();
        lbl_date1 = new javax.swing.JTextField();
        txt_update2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbl_img2 = new javax.swing.JLabel();
        gtf = new javax.swing.JTextField();
        sstf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        combobed = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        lbl_date = new javax.swing.JMenu();
        lbl_time = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(172, 226, 225));

        jPanel6.setBackground(new java.awt.Color(113, 201, 206));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14), new java.awt.Color(0, 51, 51))); // NOI18N

        jLabel37.setText("File No");

        searchTF.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                searchTFComponentRemoved(evt);
            }
        });
        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });
        searchTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTFKeyReleased(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(247, 238, 221));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 0, 18))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setText("Contact :");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 345, -1, -1));
        jPanel7.add(contactTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 342, 168, -1));

        jLabel39.setText("Select a Bed");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 318, -1, -1));

        jLabel40.setText("Gender:");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 178, -1, -1));
        jPanel7.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 126, 177, -1));

        jLabel41.setText("Age");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 126, -1, -1));
        jPanel7.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 97, 177, -1));

        jLabel42.setText("address");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 100, -1, -1));

        jLabel43.setText("First name :");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 71, -1, -1));

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel7.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 68, 177, -1));

        fileno.setEditable(false);
        fileno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenoActionPerformed(evt);
            }
        });
        jPanel7.add(fileno, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 39, 177, -1));

        jLabel44.setText("Employee id :");
        jPanel7.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 45, -1, -1));

        jLabel45.setText("Date :");
        jPanel7.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 380, 71, -1));

        jLabel46.setText("Time:");
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 409, -1, -1));
        jPanel7.add(lbl_time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 406, 260, -1));
        jPanel7.add(lbl_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 377, 260, -1));

        txt_update2.setText("Admit ");
        txt_update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_update2ActionPerformed(evt);
            }
        });
        jPanel7.add(txt_update2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 150, 40));

        jButton3.setText("Clear All");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 125, 40));
        jPanel7.add(lbl_img2, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 39, 143, 264));

        gtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gtfActionPerformed(evt);
            }
        });
        jPanel7.add(gtf, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 175, 177, -1));

        sstf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sstfActionPerformed(evt);
            }
        });
        jPanel7.add(sstf, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 224, 254, 71));

        jLabel1.setText("Special Notices");
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 238, -1, -1));

        combobed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combobedActionPerformed(evt);
            }
        });
        jPanel7.add(combobed, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 313, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Screenshot (211).png"))); // NOI18N
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, -1));
        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 120, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(65, 201, 226));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(65, 201, 226));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        lbl_date.setText("Date");
        jMenuBar1.add(lbl_date);

        lbl_time.setText("time");
        jMenuBar1.add(lbl_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFKeyReleased

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFActionPerformed

    private void searchTFComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_searchTFComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFComponentRemoved

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fileno.setText("");
        name.setText(""); 
        address.setText(""); 
        age.setText("");  
        gtf.setText("");
        sstf.setText("");
        contactTF.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_update2ActionPerformed
            StudentController.Addmission(fileno.getText(), name.getText(),address.getText(), gtf.getText(),age.getText(),combobed.getSelectedItem().toString(),contactTF.getText(),lbl_date1.getText(),lbl_time1.getText());
            StudentController.beds(fileno.getText(),name.getText(),combobed.getSelectedItem().toString());
            // TODO add your handling code here:
    }//GEN-LAST:event_txt_update2ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed

       
        
        String fNum = searchTF.getText();
        
        
        try{
            
            String FileNo = null;
            String Name = null;
            String Address = null;
           String Age  = null;
           String Gender = null;
            String Special = null;
          
           
            ResultSet rs = new DBSearch().searchpatient(fNum);
            
            while(rs.next()){
                
                  Name= rs.getString("Name");
                  Address = rs.getString("Address");
                 FileNo= rs.getString("File_Number");
                 Age= rs.getString("Age");
                 Gender= rs.getString("Gender");
                 Special= rs.getString("Special");
                


                   if(fNum.equals("")){
                   
                   JOptionPane.showMessageDialog(null, "Please Enter Valid File Number", "Error", JOptionPane.ERROR_MESSAGE);
                   
                   }
                   else{
                  
            
                  
            
         name.setText(Name);
         address.setText(Address);
         fileno.setText(FileNo);
         age.setText(Age);
         gtf.setText(Gender);
         sstf.setText(Special);}
            }
        

            
        //    System.out.println(indexNumber+" "+email+" "+password+" "+gender+" "+faculty+" "+intake);
         DBConnection.closeCon();
        }
        catch(SQLException ex){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        searchTF.setText("");
        
                // TODO add your handling code here:
    }//GEN-LAST:event_searchBtnActionPerformed

    private void filenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filenoActionPerformed

    private void gtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gtfActionPerformed

    private void combobedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combobedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combobedActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     this.setVisible(false); 
         new NursePage().setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sstfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sstfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sstfActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admission.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admission().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JComboBox<String> combobed;
    private javax.swing.JTextField contactTF;
    private javax.swing.JTextField fileno;
    private javax.swing.JTextField gtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu lbl_date;
    private javax.swing.JTextField lbl_date1;
    private javax.swing.JLabel lbl_img2;
    private javax.swing.JMenu lbl_time;
    private javax.swing.JTextField lbl_time1;
    private javax.swing.JTextField name;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField sstf;
    private javax.swing.JButton txt_update2;
    // End of variables declaration//GEN-END:variables
}
