package main.java.Interact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class DeleteUser implements Operation {

    @Override
    public void operation(Database database,User currentUser) {
        JFrame frame = new JFrame("Delete User");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Table to display users
        DefaultTableModel userModel = new DefaultTableModel();
        userModel.setColumnIdentifiers(new String[]{"ID", "First Name", "Last Name", "Email", "Phone Number", "User Type"});
        JTable userTable = new JTable(userModel);
        JScrollPane userScrollPane = new JScrollPane(userTable);

        // Load user data into table
        try {
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM user;");
            while (rs.next()) {
                if (rs.getInt("id") != currentUser.getID()) { // Prevent displaying current user
                    userModel.addRow(new Object[]{
                            rs.getInt("id"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("email"),
                            rs.getString("phoneNum"),
                            rs.getInt("typeNum") == 0 ? "Client" : "Admin"
                    });
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error loading user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Delete button
        JButton deleteButton = new JButton("Delete Selected User");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(frame, "Please select a user to delete.", "Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int userId = (int) userModel.getValueAt(selectedRow, 0);
                int confirmation = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to delete user with ID: " + userId + "?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION);

                if (confirmation == JOptionPane.YES_OPTION) {
                    try {
                        String deleteQuery = "DELETE FROM user WHERE id = '" + userId + "'";
                        database.getStatement().execute(deleteQuery);
                        userModel.removeRow(selectedRow); // Remove from table
                        JOptionPane.showMessageDialog(frame, "User deleted successfully!");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(frame, "Error deleting user: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Add components to frame
        frame.add(userScrollPane, BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
