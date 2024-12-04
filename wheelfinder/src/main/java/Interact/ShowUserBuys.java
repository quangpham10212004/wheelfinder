package main.java.Interact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class ShowUserBuys implements Operation {
    private int typeNum;

    public ShowUserBuys(int userID) {
        this.typeNum = userID;
    }

    public ShowUserBuys() {
    }

    public int getTypeNum() {
        return typeNum;
    }

    @Override
    public void operation(Database database,User user) {
        JFrame frame = new JFrame("User Purchase History");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel();
        JLabel userIdLabel = new JLabel("Enter User ID (if admin): ");
        JTextField userIdField = new JTextField(10);
        JButton showButton = new JButton("Show Purchases");

        inputPanel.add(userIdLabel);
        inputPanel.add(userIdField);
        inputPanel.add(showButton);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");
                try {
                    String select;
                    int tn = getTypeNum();
                    if (tn == 0) {
                        if (userIdField.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please enter a User ID!", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        int uID = Integer.parseInt(userIdField.getText());
                        select = "SELECT * FROM buys WHERE user_id = '" + uID + "';";
                    } else {
                        select = "SELECT * FROM buys WHERE user_id = '" + user.getID() + "';";
                    }

                    ResultSet rs = database.getStatement().executeQuery(select);
                    double total = 0;
                    ArrayList<Integer> carIDs = new ArrayList<>();
                    ArrayList<String> times = new ArrayList<>();

                    if (!rs.next()) {
                        displayArea.append("No purchases found.\n");
                        return;
                    }
                    do {
                        int car_id = rs.getInt("car_id");
                        carIDs.add(car_id);
                        times.add(rs.getString("timeBuy"));
                        total += rs.getDouble("totalFee");
                    } while (rs.next());

                    displayArea.append("Client's Information:\n");
                    ResultSet userRs = database.getStatement().executeQuery("SELECT * FROM user WHERE id = '" + user.getID() + "';");
                    userRs.next();
                    displayArea.append("Full Name: " + userRs.getString("lastName") + " " + userRs.getString("firstName") + "\n");
                    displayArea.append("Email: " + userRs.getString("email") + "\n");
                    displayArea.append("Phone Number: " + userRs.getString("phoneNum") + "\n");
                    displayArea.append("\nCars Purchased:\n");
                    displayArea.append("---------------------------------\n");

                    int dem = 0;
                    for (Integer id : carIDs) {
                        ResultSet carRs = database.getStatement().executeQuery("SELECT * FROM car WHERE ID = '" + id + "';");
                        carRs.next();
                        displayArea.append("ID: " + carRs.getInt("ID") + "\n");
                        displayArea.append("Car's Name: " + carRs.getString("brand") + " " + carRs.getString("model") + " " + carRs.getString("color") + "\n");
                        displayArea.append("Year Of Manufacture: " + carRs.getString("yearRelease") + "\n");
                        displayArea.append("Price: " + carRs.getDouble("price") + "$\n");
                        displayArea.append("Bought At: " + times.get(dem) + "\n");
                        displayArea.append("---------------------------------\n");
                        dem++;
                    }
                    displayArea.append("Total Fee: " + total + "$\n");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Error retrieving data. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid User ID format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }
}
