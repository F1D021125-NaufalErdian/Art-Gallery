/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author ASUS
 */
public class WelcomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    CardLayout cardLayout;
    public WelcomeFrame() {
        setResizable(false);

        initComponents();
        setLocationRelativeTo(null);
        CardPanel.add(Login, "Login");
        CardPanel.add(Register, "Register");
        cardLayout = (CardLayout)(CardPanel.getLayout());
        
    }
    @SuppressWarnings("unchecked")
    
    public void mouseEnter(JButton panel){
        panel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                panel.setForeground(Color.BLUE);
                panel.setFont(panel.getFont().deriveFont(Font.BOLD));
            }
            @Override
            public void mouseExited(MouseEvent e){
                panel.setForeground(Color.BLACK);
                panel.setFont(panel.getFont().deriveFont(Font.PLAIN));
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        project1 = new project.Project();
        Welcome = new javax.swing.JLabel();
        CardPanel = new javax.swing.JPanel();
        Login = new keeptoo.KGradientPanel();
        LoginButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        nameLogin1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        RegisterPanel1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        passLogin1 = new javax.swing.JPasswordField();
        Register = new keeptoo.KGradientPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nameRegis = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        passRegis = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        confirmPassRegis = new javax.swing.JPasswordField();
        RegisterButton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        LoginPanel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Welcome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component/Women2.png"))); // NOI18N

        CardPanel.setLayout(new java.awt.CardLayout());

        Login.setkEndColor(new java.awt.Color(255, 204, 204));
        Login.setkStartColor(new java.awt.Color(204, 204, 255));
        Login.setLayout(null);

        LoginButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginButton1.setText("Login");
        LoginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButton1ActionPerformed(evt);
            }
        });
        Login.add(LoginButton1);
        LoginButton1.setBounds(130, 274, 221, 35);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Login");
        Login.add(jLabel6);
        jLabel6.setBounds(130, 61, 221, 57);

        jLabel15.setText("Username");
        Login.add(jLabel15);
        jLabel15.setBounds(130, 130, 80, 16);

        nameLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameLogin1ActionPerformed(evt);
            }
        });
        Login.add(nameLogin1);
        nameLogin1.setBounds(130, 152, 221, 35);

        jLabel16.setText("Password");
        Login.add(jLabel16);
        jLabel16.setBounds(130, 199, 80, 16);

        RegisterPanel1.setText("Daftar");
        RegisterPanel1.setBorder(null);
        RegisterPanel1.setBorderPainted(false);
        RegisterPanel1.setContentAreaFilled(false);
        RegisterPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegisterPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterPanel1MouseClicked(evt);
            }
        });
        RegisterPanel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterPanel1ActionPerformed(evt);
            }
        });
        Login.add(RegisterPanel1);
        RegisterPanel1.setBounds(270, 320, 40, 16);

        jLabel17.setText("Belum punya akun?");
        Login.add(jLabel17);
        jLabel17.setBounds(160, 320, 110, 16);

        passLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passLogin1ActionPerformed(evt);
            }
        });
        Login.add(passLogin1);
        passLogin1.setBounds(130, 221, 220, 35);

        CardPanel.add(Login, "card4");

        Register.setkEndColor(new java.awt.Color(204, 204, 255));
        Register.setkStartColor(new java.awt.Color(255, 204, 204));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Register");

        jLabel11.setText("Username");

        nameRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameRegisActionPerformed(evt);
            }
        });

        jLabel12.setText("Password");

        jLabel14.setText("Confirm Password");

        confirmPassRegis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPassRegisActionPerformed(evt);
            }
        });

        RegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        jLabel13.setText("Sudah punya akun?");

        LoginPanel.setText("Masuk");
        LoginPanel.setBorder(null);
        LoginPanel.setBorderPainted(false);
        LoginPanel.setContentAreaFilled(false);
        LoginPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LoginPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RegisterLayout = new javax.swing.GroupLayout(Register);
        Register.setLayout(RegisterLayout);
        RegisterLayout.setHorizontalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisterLayout.createSequentialGroup()
                .addGap(0, 155, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LoginPanel)
                .addGap(185, 185, 185))
            .addGroup(RegisterLayout.createSequentialGroup()
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameRegis)
                                .addComponent(RegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(passRegis)
                                .addComponent(confirmPassRegis))
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)))
                    .addGroup(RegisterLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel10)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RegisterLayout.setVerticalGroup(
            RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel10)
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPassRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginPanel)
                    .addComponent(jLabel13))
                .addGap(105, 105, 105))
        );

        CardPanel.add(Register, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Welcome)
                .addGap(0, 0, 0)
                .addComponent(CardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Welcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passLogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passLogin1ActionPerformed

    private void RegisterPanel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterPanel1ActionPerformed
        RegisterPanel1.setForeground(Color.WHITE);
        cardLayout.show(CardPanel, "Register");
        mouseEnter(RegisterPanel1);
    }//GEN-LAST:event_RegisterPanel1ActionPerformed

    private void nameLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameLogin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameLogin1ActionPerformed

    private void LoginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButton1ActionPerformed
        try{
            boolean connect = Connect.LoginConnection(passLogin1, nameLogin1);
            if(connect){
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_LoginButton1ActionPerformed

    private void nameRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameRegisActionPerformed

    private void confirmPassRegisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPassRegisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPassRegisActionPerformed

    private void LoginPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginPanelActionPerformed
        cardLayout.show(CardPanel, "Login");
        mouseEnter(LoginPanel);
    }//GEN-LAST:event_LoginPanelActionPerformed

    private void RegisterPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_RegisterPanel1MouseClicked

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        try{
            boolean connect = Connect.RegisterConnection(passRegis, confirmPassRegis, nameRegis);
            cardLayout.show(CardPanel, "Login");
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_RegisterButtonActionPerformed
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
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CardPanel;
    private keeptoo.KGradientPanel Login;
    private javax.swing.JButton LoginButton1;
    private javax.swing.JButton LoginPanel;
    private keeptoo.KGradientPanel Register;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JButton RegisterPanel1;
    private javax.swing.JLabel Welcome;
    private javax.swing.JPasswordField confirmPassRegis;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nameLogin1;
    private javax.swing.JTextField nameRegis;
    private javax.swing.JPasswordField passLogin1;
    private javax.swing.JPasswordField passRegis;
    private project.Project project1;
    // End of variables declaration//GEN-END:variables
}
