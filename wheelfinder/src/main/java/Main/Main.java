package main.java.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.Entity.Admin;
import main.java.Entity.Client;
import main.java.Entity.Database;
import main.java.Entity.User;
import main.java.Interact.AddNewAccount;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();

        // Tạo frame chính
        JFrame frame = new JFrame("WheelFinder - Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        // Tiêu đề
        JLabel welcomeLabel = new JLabel("Welcome to WheelFinder", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(welcomeLabel);

        // Khu vực nhập email
        JPanel emailPanel = new JPanel();
        emailPanel.setLayout(new FlowLayout());
        JLabel emailLabel = new JLabel("Email: ");
        JTextField emailField = new JTextField(20);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        frame.add(emailPanel);

        // Khu vực nhập password
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        frame.add(passwordPanel);

        // Khu vực nút
        JPanel buttonPanel = new JPanel();
        JButton loginButton = new JButton("Login");
        JButton createAccountButton = new JButton("Create Account");
        buttonPanel.add(loginButton);
        buttonPanel.add(createAccountButton);
        frame.add(buttonPanel);

        frame.setVisible(true);

        // Xử lý sự kiện nút "Create Account"
        createAccountButton.addActionListener(e -> {
            new AddNewAccount(0).operation(database, null);
            JOptionPane.showMessageDialog(frame, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });

        // Xử lý sự kiện nút "Login"
        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            ArrayList<User> users = new ArrayList<>();

            try {
                String select = "SELECT * FROM user;";
                ResultSet rs = database.getStatement().executeQuery(select);
                while (rs.next()) {
                    User user;
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String em = rs.getString("email");
                    String phoneNum = rs.getString("phoneNum");
                    String pass = rs.getString("passwrd");
                    int type = rs.getInt("typeNum");

                    if (type == 0) {
                        user = new Client();
                    } else if (type == 1) {
                        user = new Admin();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid account type!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    user.setID(id);
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(em);
                    user.setPhoneNum(phoneNum);
                    user.setPassword(pass);
                    users.add(user);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Database error!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean loginSuccessful = false;
            for (User us : users) {
                if (us.getEmail().equals(email) && us.getPassword().equals(password)) {
                    loginSuccessful = true;
                    JOptionPane.showMessageDialog(frame, "Welcome " + us.getFirstName() + "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose(); // Đóng frame hiện tại
                    us.showList(database, null); // Hiển thị giao diện tương ứng với user
                }
            }

            if (!loginSuccessful) {
                JOptionPane.showMessageDialog(frame, "Invalid email or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
