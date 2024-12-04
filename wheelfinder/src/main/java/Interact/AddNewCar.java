package main.java.Interact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class AddNewCar implements Operation {
    @Override
    public void operation(Database database, User user) {
        // Tạo JFrame
        JFrame frame = new JFrame("Add New Car");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(7, 2, 10, 10));

        // Thêm các thành phần giao diện
        JLabel brandLabel = new JLabel("Brand:");
        JTextField brandField = new JTextField();

        JLabel modelLabel = new JLabel("Model:");
        JTextField modelField = new JTextField();

        JLabel colorLabel = new JLabel("Color:");
        JTextField colorField = new JTextField();

        JLabel yearReleaseLabel = new JLabel("Year Release:");
        JTextField yearReleaseField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();

        JLabel availableLabel = new JLabel("Available:");
        JTextField availableField = new JTextField();

        JButton submitButton = new JButton("Add Car");

        // Thêm các thành phần vào frame
        frame.add(brandLabel);
        frame.add(brandField);

        frame.add(modelLabel);
        frame.add(modelField);

        frame.add(colorLabel);
        frame.add(colorField);

        frame.add(yearReleaseLabel);
        frame.add(yearReleaseField);

        frame.add(priceLabel);
        frame.add(priceField);

        frame.add(availableLabel);
        frame.add(availableField);

        frame.add(new JLabel()); // Placeholder
        frame.add(submitButton);

        frame.setVisible(true);

        // Xử lý sự kiện khi nhấn nút "Add Car"
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brand = brandField.getText();
                String model = modelField.getText();
                String color = colorField.getText();
                String yearRelease = yearReleaseField.getText();
                String priceText = priceField.getText();
                String availableText = availableField.getText();

                // Kiểm tra tính hợp lệ của dữ liệu
                if (brand.isEmpty() || model.isEmpty() || color.isEmpty() ||
                        yearRelease.isEmpty() || priceText.isEmpty() || availableText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    double price = Double.parseDouble(priceText);
                    int available = Integer.parseInt(availableText);

                    // Chèn dữ liệu vào cơ sở dữ liệu
                    String insert = "INSERT INTO car (brand, model, color, yearRelease, price, available) " +
                            "VALUES ('" + brand + "', '" + model + "', '" + color + "', '" + yearRelease + "', '" + price + "', '" + available + "')";
                    database.getStatement().execute(insert);

                    JOptionPane.showMessageDialog(frame, "Car added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose(); // Đóng form sau khi thêm thành công
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Price and Available must be valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error adding car to the database!", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });
    }
}
