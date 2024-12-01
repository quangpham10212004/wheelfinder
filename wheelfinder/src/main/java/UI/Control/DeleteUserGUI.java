/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.UI.Control;

import java.sql.SQLException;
import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;
import main.java.Interact.ViewAllUser;

/**
 *
 * @author admin
 */
public class DeleteUserGUI extends javax.swing.JFrame implements Operation {

    public DeleteUserGUI(Database database, Scanner sc, User user) {
        this.database = database;
        this.sc = sc;
        this.user = user;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        userID = new javax.swing.JTextField();
        delUserButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Delete Car");
        setMinimumSize(new java.awt.Dimension(320, 200));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(54, 171, 239));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Delete User");

        idLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idLabel.setText("User's ID");

        userID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIDActionPerformed(evt);
            }
        });

        delUserButton.setBackground(new java.awt.Color(54, 171, 239));
        delUserButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        delUserButton.setForeground(new java.awt.Color(255, 255, 255));
        delUserButton.setText("Delete");
        delUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delUserButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(54, 171, 239));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delUserButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(idLabel)
                        .addGap(34, 34, 34)
                        .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(userID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delUserButton)
                    .addComponent(cancelButton))
                .addContainerGap(71, Short.MAX_VALUE))
        );

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

        setSize(new java.awt.Dimension(334, 207));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIDActionPerformed

    private void delUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delUserButtonActionPerformed
        int id = Integer.parseInt(userID.getText());
        int cur_id = user.getID();
        while (id == -1 || id == cur_id) {
            if (id == -1) {
                new ViewAllUser().operation(database, sc, user);
            }
            if (id == cur_id) {
                System.out.println("You Can Not Delete Yourself");
            }
            System.out.println("Enter ID Of The User: (-1) to View All Users");
            id = sc.nextInt();
        }
        try {
            String del = "delete from user where id ='" + id + "'";
            database.getStatement().execute(del);
            System.out.println("User Deleted Successfully!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_delUserButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed
    private Database database;
    private Scanner sc;
    private User user;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton delUserButton;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField userID;
    // End of variables declaration//GEN-END:variables
public void operation(Database database, Scanner sc, User user) {
        java.awt.EventQueue.invokeLater(() -> {
            DeleteUserGUI frame = new DeleteUserGUI(database, sc, user);
            frame.setVisible(true);
        });
    }
}
