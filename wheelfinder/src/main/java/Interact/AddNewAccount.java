package main.java.Interact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.Entity.Client;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class AddNewAccount implements Operation {
    private int accType;

    public AddNewAccount(int accType) {
        this.accType = accType;
    }

    @Override
    public void operation(Database database, User user) {
        // Tạo JFrame
        JFrame frame = new JFrame("Create New Account");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//tat ma k thoat ca ung dung
        frame.setLayout(new GridLayout(8, 2, 10, 10));

        // Thêm các thành phần giao diện
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField();

        JLabel phoneNumLabel = new JLabel("Phone Number:");
        JTextField phoneNumField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel rePasswordLabel = new JLabel("Confirm Password:");
        JPasswordField rePasswordField = new JPasswordField();

        JButton submitButton = new JButton("Create Account");

        // Thêm các thành phần vào frame
        frame.add(firstNameLabel);
        frame.add(firstNameField);

        frame.add(lastNameLabel);
        frame.add(lastNameField);

        frame.add(phoneNumLabel);
        frame.add(phoneNumField);

        frame.add(emailLabel);
        frame.add(emailField);

        frame.add(passwordLabel);
        frame.add(passwordField);

        frame.add(rePasswordLabel);
        frame.add(rePasswordField);

        frame.add(new JLabel()); // Placeholder
        frame.add(submitButton);

        frame.setVisible(true);

        // Xử lý sự kiện khi nhấn nút "Create Account"
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String phoneNum = phoneNumField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String rePassword = new String(rePasswordField.getPassword());

                if (!password.equals(rePassword)) {
                    JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Kiểm tra email trùng lặp
                    ArrayList<String> emails = new ArrayList<>();
                    ResultSet temp = database.getStatement().executeQuery("SELECT email FROM user;");
                    while (temp.next()) {
                        emails.add(temp.getString("email"));
                    }

                    if (emails.contains(email)) {
                        JOptionPane.showMessageDialog(frame, "This email is already used. Please try another email.", "Error", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Chèn thông tin vào cơ sở dữ liệu
                    String insert = "INSERT INTO user (firstName, lastName, email, phoneNum, passwrd, typeNum) " +
                            "VALUES ('" + firstName + "','" + lastName + "','" + email + "','" + phoneNum + "','" + password + "','" + accType + "')";
                    database.getStatement().execute(insert);

                    JOptionPane.showMessageDialog(frame, "Account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Nếu là tài khoản khách hàng, tự động chuyển đến danh sách thao tác
                    if (accType == 0) {
                        Client user = new Client();
                        user.setFirstName(firstName);
                        user.setLastName(lastName);
                        user.setEmail(email);
                        user.setPhoneNum(phoneNum);
                        user.setPassword(password);

                        frame.dispose();
                        user.showList(database,user); // Chuyển sang danh sách thao tác
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error creating account!", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }
}
