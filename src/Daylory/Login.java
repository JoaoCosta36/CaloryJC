/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daylory;
import java.sql.SQLException; 
import java.sql.Statement;
import java.sql.*;
import java.sql.Connection;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author joao.costa
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form TABLE_CALORIES_CaloryJC
     */
    public Login() throws Exception {
       //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            initComponents();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(255, 204, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Perpetua", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("Login");

        jLabel2.setText("Email");

        jLabel3.setText("Password");

        jButton1.setText("Entrar");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jPasswordField1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1)))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con=null;
        //Menu Calory = new Menu();
        Statement stmt;
        ResultSet rs;
        String url ="jdbc:mysql://localhost/caloryjc";
        String User ="root";
        String password="!Passw0rd#";
        String driver = "com.mysql.jdbc.Driver"; 
         try{
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(url, User, password);
            stmt = con.createStatement();
           // System.out.println(con);
            String Email= jTextField1.getText();
            String passwordz = jPasswordField1.getText();
            rs = stmt.executeQuery("SELECT email, password, Privileges FROM login");
           
           int count=0;
            while ( rs.next() ) {
                String dbUsername = rs.getString("email");
                String dbPassword = rs.getString("password");
               // String priv = rs.getString("Privileges");
                
                if(Email.equals(dbUsername) && passwordz.equals(dbPassword)){ 
                    count=count+1;
                     if(count==1)
                     {
                         /*if(priv.equals("Admin"))
                    {*/
                     JOptionPane.showMessageDialog(null, "Login bem sucedido!", "Login bem sucedido!", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                     userPrivileges usrpr = new userPrivileges();
                    usrpr.setVisible(true);
            //Calory.setVisible(true);
                    }else{
                       jTextField1.setText("");
                jPasswordField1.setText("");JOptionPane.showMessageDialog(null, "Não tens permissões ", "Permissons!", JOptionPane.INFORMATION_MESSAGE); 
                    //}
                }
                
                }else if(count==0){
                    jTextField1.setText("");
                jPasswordField1.setText("");JOptionPane.showMessageDialog(null, "Login errado", "Login incorreto", JOptionPane.INFORMATION_MESSAGE);}
                
            }
            

        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Not Found", "Utilizador não encontrado", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //String User = "Admin";
        //String password = "Passw0rd";
        /* **************************************************************try {
            Login close = new  Login();
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
 GerirCalorias Calory = new GerirCalorias();
    
        if(jTextField1.getText().equals(User)&& jPasswordField1.getText().equals(password))
{
            JOptionPane.showMessageDialog(null, "Login bem sucedido!", "Login bem sucedido!", JOptionPane.INFORMATION_MESSAGE);
            Calory.setVisible(true);
            this.dispose();
    
}
        else
        {
            JOptionPane.showMessageDialog(null, "Login errado", "Login incorreto", JOptionPane.INFORMATION_MESSAGE);
        }*/
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {Connection con=null;
        //Menu Calory = new Menu();
        Statement stmt;
        ResultSet rs;
        String url ="jdbc:mysql://127.0.0.1/caloryjc";
        String user ="root";
        String password="!Passw0rd#";
        String driver = "com.mysql.jdbc.Driver"; 
         try{
            Class.forName(driver).newInstance();
            con = (Connection) DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
           // System.out.println(con);
             String IMAILE= jTextField1.getText();
            String passwordz = jPasswordField1.getText();
            rs = stmt.executeQuery("SELECT email, password,Privileges FROM Login");
           
           int count=0;
            while ( rs.next() ) {
                String dbusername = rs.getString("email");
                String dbPassword = rs.getString("password");
                //String dbPrivileges = rs.getString("Privileges");
               
                if(dbusername.equals(IMAILE) && dbPassword.equals(passwordz))
                {   
                    count=count+1;   
                    
                    if(count==1 ){
                    
                     JOptionPane.showMessageDialog(null, "Dados corretos!", "Login", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                     userPrivileges usrpr = new userPrivileges();
                    usrpr.setVisible(true);            
                     //Calory.setVisible(true);
                    }
                    else if(count==0)
                    {
                    jTextField1.setText("");
                jPasswordField1.setText("");JOptionPane.showMessageDialog(null, "Login errado", "Login incorreto", JOptionPane.INFORMATION_MESSAGE);
                    }                  
                                                }
                }

        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Not Found", "Utilizador não encontrado", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    }//GEN-LAST:event_jPasswordField1KeyPressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
