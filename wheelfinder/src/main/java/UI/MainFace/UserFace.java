/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main.java.UI.MainFace;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import main.java.Entity.Database;

/**
 *
 * @author admin
 */
public class UserFace extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public UserFace() {
        initComponents();
        loadCarData();
        loadBuyData();
    }
    
    class jPanelGradient extends JPanel {
        protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = new Color(100,57,255);
        Color color2 = new Color(124,245,255);
        int width = getWidth();
        int height = getHeight();
        GradientPaint gradientPaint = new GradientPaint(0, 0, color1, 0 , height, color2);
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height);
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

        bigContainer = new jPanelGradient();
        sideBar = new javax.swing.JPanel();
        sideBarLogo = new javax.swing.JLabel();
        menuItemUserPanel = new jPanelGradient();
        buyCarButton = new javax.swing.JButton();
        showMyBuyButton = new javax.swing.JButton();
        changePassButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wheel Finder User");
        setResizable(false);

        sideBar.setBackground(new java.awt.Color(54, 171, 239));
        sideBar.setAlignmentX(0.0F);
        sideBar.setAlignmentY(0.0F);

        sideBarLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/java/UI/logo/logoandtext100.png"))); // NOI18N

        menuItemUserPanel.setBackground(new java.awt.Color(255, 255, 255));

        buyCarButton.setBackground(new java.awt.Color(54, 171, 239));
        buyCarButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buyCarButton.setForeground(new java.awt.Color(255, 255, 255));
        buyCarButton.setText("Buy Car");
        buyCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyCarButtonActionPerformed(evt);
            }
        });

        showMyBuyButton.setBackground(new java.awt.Color(54, 171, 239));
        showMyBuyButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showMyBuyButton.setForeground(new java.awt.Color(255, 255, 255));
        showMyBuyButton.setText("Show My Buys");
        showMyBuyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMyBuyButtonActionPerformed(evt);
            }
        });

        changePassButton.setBackground(new java.awt.Color(54, 171, 239));
        changePassButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        changePassButton.setForeground(new java.awt.Color(255, 255, 255));
        changePassButton.setText("Change Password");
        changePassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePassButtonActionPerformed(evt);
            }
        });

        logOutButton.setBackground(new java.awt.Color(54, 171, 239));
        logOutButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logOutButton.setForeground(new java.awt.Color(255, 255, 255));
        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuItemUserPanelLayout = new javax.swing.GroupLayout(menuItemUserPanel);
        menuItemUserPanel.setLayout(menuItemUserPanelLayout);
        menuItemUserPanelLayout.setHorizontalGroup(
            menuItemUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buyCarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(showMyBuyButton)
                .addGap(18, 18, 18)
                .addGroup(menuItemUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePassButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuItemUserPanelLayout.setVerticalGroup(
            menuItemUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuItemUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuItemUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buyCarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(menuItemUserPanelLayout.createSequentialGroup()
                        .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(showMyBuyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("@Drive with freedom, built on nocopyright.");

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(sideBarLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(menuItemUserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarLayout.createSequentialGroup()
                        .addComponent(sideBarLogo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(menuItemUserPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(25, 25, 25))
        );

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Brand", "Model", "Colour", "Year Realease", "Price", "Current Number"
            }
        ));
        jScrollPane3.setViewportView(carTable);

        javax.swing.GroupLayout bigContainerLayout = new javax.swing.GroupLayout(bigContainer);
        bigContainer.setLayout(bigContainerLayout);
        bigContainerLayout.setHorizontalGroup(
            bigContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bigContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
                .addContainerGap())
        );
        bigContainerLayout.setVerticalGroup(
            bigContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bigContainerLayout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bigContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bigContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1134, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buyCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyCarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buyCarButtonActionPerformed

    private void changePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePassButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changePassButtonActionPerformed

    private void showMyBuyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMyBuyButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showMyBuyButtonActionPerformed

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFace().setVisible(true);
            }
        });
    }
    public void loadCarData() {
    try (Database db = new Database()) { // Sử dụng try-with-resources để tự động đóng kết nối
        Connection conn = db.getConnection(); // Lấy kết nối từ class Database
        if (conn == null) {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
            return;
        }

        String query = "SELECT id, brand, model, color, yearRelease, price, available FROM car";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Lấy mô hình bảng và xóa dữ liệu cũ
        DefaultTableModel tableModel = (DefaultTableModel) carTable.getModel();
        tableModel.setRowCount(0);

        // Thêm dữ liệu mới vào bảng
        while (rs.next()) {
            Object[] row = new Object[7];
            row[0] = rs.getInt("id");
            row[1] = rs.getString("brand");
            row[2] = rs.getString("model");
            row[3] = rs.getString("color");
            row[4] = rs.getInt("yearRelease"); // Chỉnh sửa lại tên cột chính xác
            row[5] = rs.getDouble("price");
            row[6] = rs.getInt("available");
            tableModel.addRow(row);
        }

        rs.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
        public void loadBuyData() {
    try (Database db = new Database()) { // Sử dụng try-with-resources để tự động đóng kết nối
        Connection conn = db.getConnection(); // Lấy kết nối từ class Database
        if (conn == null) {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
            return;
        }
        String query = "SELECT id, car_id, timeBuy, totalFee FROM buys";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Lấy mô hình bảng và xóa dữ liệu cũ
        DefaultTableModel tableModel = (DefaultTableModel) BuyUserTable.getModel();
        tableModel.setRowCount(0);

        // Thêm dữ liệu mới vào bảng
        while (rs.next()) {
            Object[] row = new Object[4];
            row[0] = rs.getInt("id");
            row[1] = rs.getString("car_id");
            row[2] = rs.getString("timeBuy");
            row[3] = rs.getInt("totalFee"); // Chỉnh sửa lại tên cột chính xác
            tableModel.addRow(row);
        }

        rs.close();
        stmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bigContainer;
    private javax.swing.JButton buyCarButton;
    private javax.swing.JTable carTable;
    private javax.swing.JButton changePassButton;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logOutButton;
    private javax.swing.JPanel menuItemUserPanel;
    private javax.swing.JButton showMyBuyButton;
    private javax.swing.JPanel sideBar;
    private javax.swing.JLabel sideBarLogo;
    // End of variables declaration//GEN-END:variables
}
