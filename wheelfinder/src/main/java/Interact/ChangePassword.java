package main.java.Interact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class ChangePassword implements Operation {

    @Override
    public void operation(Database database, User user) {
        JFrame frame = new JFrame("Change Password");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        // Labels and Text Fields
        JLabel oldPassLabel = new JLabel("Enter your old password:");
        JPasswordField oldPassField = new JPasswordField();

        JLabel newPassLabel = new JLabel("Enter your new password:");
        JPasswordField newPassField = new JPasswordField();

        JLabel confirmPassLabel = new JLabel("Confirm your new password:");
        JPasswordField confirmPassField = new JPasswordField();

        JButton submitButton = new JButton("Change Password");
        JButton cancelButton = new JButton("Cancel");

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.add(oldPassLabel);
        inputPanel.add(oldPassField);
        inputPanel.add(newPassLabel);
        inputPanel.add(newPassField);
        inputPanel.add(confirmPassLabel);
        inputPanel.add(confirmPassField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        frame.add(inputPanel);
        frame.add(buttonPanel);

        // Button Actions
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldPassword = new String(oldPassField.getPassword());
                String newPassword = new String(newPassField.getPassword());
                String confirmPassword = new String(confirmPassField.getPassword());

                if (!oldPassword.equals(user.getPassword())) {
                    JOptionPane.showMessageDialog(frame, "Old password is incorrect!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    String updateQuery = "UPDATE user SET passwrd = '" + newPassword + "' WHERE email = '" + user.getEmail() + "'";
                    database.getStatement().execute(updateQuery);
                    JOptionPane.showMessageDialog(frame, "Password changed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error changing password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        cancelButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
