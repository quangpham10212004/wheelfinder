package main.java.Interact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class DeleteCar implements Operation {
    @Override
    public void operation(Database database,User user) {
        JFrame frame = new JFrame("Delete Car");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel instructionLabel = new JLabel("Enter the ID of the car you want to delete:");
        JTextField idField = new JTextField();

        JTextArea carListArea = new JTextArea();
        carListArea.setEditable(false);

        JButton showAllButton = new JButton("Show All Cars");
        JButton deleteButton = new JButton("Delete");
        JButton cancelButton = new JButton("Cancel");

        JPanel inputPanel = new JPanel(new GridLayout(2, 1));
        inputPanel.add(instructionLabel);
        inputPanel.add(idField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(showAllButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(cancelButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(carListArea), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder carList = new StringBuilder();
                try {
                    ResultSet rs = database.getStatement().executeQuery("SELECT * FROM car;");
                    while (rs.next()) {
                        carList.append("ID: ").append(rs.getInt("ID")).append("\n")
                                .append("Brand: ").append(rs.getString("brand")).append("\n")
                                .append("Model: ").append(rs.getString("model")).append("\n")
                                .append("Color: ").append(rs.getString("color")).append("\n")
                                .append("Price: ").append(rs.getDouble("price")).append("\n")
                                .append("Available: ").append(rs.getInt("available")).append("\n")
                                .append("--------------------------------\n");
                    }
                } catch (SQLException ex) {
                    carList.append("Error loading car list.");
                    ex.printStackTrace();
                }
                carListArea.setText(carList.toString());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int carId = Integer.parseInt(idField.getText());
                    String deleteQuery = "DELETE FROM car WHERE ID = '" + carId + "'";
                    int rowsAffected = database.getStatement().executeUpdate(deleteQuery);

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(frame, "Car deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Car ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Error deleting car. Please check the ID and try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        });

        cancelButton.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }
}
