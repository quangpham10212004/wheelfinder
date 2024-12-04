package main.java.Interact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.Entity.Car;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class UpdateCar implements Operation {
    @Override
    public void operation(Database database, User user) {
        JFrame frame = new JFrame("Update Car");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(8, 2, 10, 10));

        // Labels and Text Fields
        JLabel idLabel = new JLabel("Car ID:");
        JTextField idField = new JTextField();

        JLabel brandLabel = new JLabel("Brand:");
        JTextField brandField = new JTextField();

        JLabel modelLabel = new JLabel("Model:");
        JTextField modelField = new JTextField();

        JLabel colorLabel = new JLabel("Color:");
        JTextField colorField = new JTextField();

        JLabel yearLabel = new JLabel("Year of Manufacture:");
        JTextField yearField = new JTextField();

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField();

        JLabel availableLabel = new JLabel("Available:");
        JTextField availableField = new JTextField();

        JButton updateButton = new JButton("Update");
        JButton cancelButton = new JButton("Cancel");

        // Adding components to frame
        frame.add(idLabel);
        frame.add(idField);
        frame.add(brandLabel);
        frame.add(brandField);
        frame.add(modelLabel);
        frame.add(modelField);
        frame.add(colorLabel);
        frame.add(colorField);
        frame.add(yearLabel);
        frame.add(yearField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(availableLabel);
        frame.add(availableField);
        frame.add(updateButton);
        frame.add(cancelButton);

        // Button Actions
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cur_id = Integer.parseInt(idField.getText());
                try {
                    // Fetch car information from database
                    ResultSet rs = database.getStatement().executeQuery("SELECT * FROM car WHERE ID = '" + cur_id + "';");
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(frame, "Car ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Car car = new Car();
                    car.setBrand(rs.getString("brand"));
                    car.setModel(rs.getString("model"));
                    car.setColor(rs.getString("color"));
                    car.setYear(rs.getInt("yearRelease"));
                    car.setPrice(rs.getDouble("price"));
                    car.setAvailable(rs.getInt("available"));

                    // Update fields if they are not empty
                    String brand = brandField.getText().isEmpty() ? car.getBrand() : brandField.getText();
                    String model = modelField.getText().isEmpty() ? car.getModel() : modelField.getText();
                    String color = colorField.getText().isEmpty() ? car.getColor() : colorField.getText();
                    int yearRelease = yearField.getText().isEmpty() ? car.getYear() : Integer.parseInt(yearField.getText());
                    double price = priceField.getText().isEmpty() ? car.getPrice() : Double.parseDouble(priceField.getText());
                    int available = availableField.getText().isEmpty() ? car.getAvailable() : Integer.parseInt(availableField.getText());

                    // Update the car information in the database
                    String update = "UPDATE car SET brand = '" + brand + "', model = '" + model + "', color = '" + color + "', " +
                            "yearRelease = '" + yearRelease + "', price = '" + price + "', available = '" + available + "' WHERE ID = '" + cur_id + "'";
                    database.getStatement().execute(update);

                    JOptionPane.showMessageDialog(frame, "Car updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error updating car!", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        cancelButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
