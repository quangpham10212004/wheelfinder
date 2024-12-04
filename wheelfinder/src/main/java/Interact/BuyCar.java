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
import main.java.Entity.Buys;
import main.java.Entity.Car;

public class BuyCar implements Operation {

	@Override
	public void operation(Database database, User user) {
		// Simple frame setup
		JFrame frame = new JFrame("Buy Car");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Title Label
		JLabel titleLabel = new JLabel("Buy a Car", JLabel.CENTER);
		frame.add(titleLabel, BorderLayout.NORTH);

		// JTextArea to display available cars
		JTextArea carListArea = new JTextArea();
		carListArea.setEditable(false); // Cannot edit the car list
		JScrollPane scrollPane = new JScrollPane(carListArea);
		frame.add(scrollPane, BorderLayout.CENTER);

		// Fetch available cars from the database
		try {
			ResultSet rs = database.getStatement().executeQuery("SELECT * FROM car WHERE available > 0;");
			StringBuilder carList = new StringBuilder("Available Cars:\n");
			while (rs.next()) {
				carList.append("ID: ").append(rs.getInt("ID")).append(", Brand: ").append(rs.getString("brand"))
						.append(", Model: ").append(rs.getString("model")).append(", Year: ")
						.append(rs.getInt("yearRelease")).append(", Price: $").append(rs.getDouble("price"))
						.append(", Available: ").append(rs.getInt("available")).append("\n");
			}
			carListArea.setText(carList.toString());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(frame, "Error loading cars!", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		// Panel for car ID input and buy button
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		JLabel idLabel = new JLabel("Enter Car ID:");
		JTextField idField = new JTextField(10);
		JButton buyButton = new JButton("Buy Car");
		inputPanel.add(idLabel);
		inputPanel.add(idField);
		inputPanel.add(buyButton);
		frame.add(inputPanel, BorderLayout.SOUTH);

		// Make the frame visible
		frame.setVisible(true);

		// Buy car action handler
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String carIDStr = idField.getText();
				if (carIDStr.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Please enter a Car ID!", "Error",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				int carID;
				try {
					carID = Integer.parseInt(carIDStr);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Invalid Car ID!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					ResultSet rs = database.getStatement()
							.executeQuery("SELECT * FROM car WHERE ID = '" + carID + "';");
					if (!rs.next()) {
						JOptionPane.showMessageDialog(frame, "Car not found!", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

					Car car = new Car();
					car.setID(rs.getInt("ID"));
					car.setBrand(rs.getString("brand"));
					car.setModel(rs.getString("model"));
					car.setColor(rs.getString("color"));
					car.setYear(rs.getInt("yearRelease"));
					car.setPrice(rs.getDouble("price"));
					car.setAvailable(rs.getInt("available"));

					if (car.getAvailable() == 0) {
						JOptionPane.showMessageDialog(frame, "This car is out of stock!", "Error",
								JOptionPane.WARNING_MESSAGE);
						return;
					}

					// Perform the transaction (car purchase)
					double totalFee = car.getPrice();
					Buys buy = new Buys();
					String insert = "INSERT INTO buys (user_id, car_id, timeBuy, totalFee) VALUES ('" + user.getID()
							+ "', '" + car.getID() + "', '" + buy.getTime() + "', '" + totalFee + "')";
					database.getStatement().execute(insert);

					// Update car availability
					int cur_number = car.getAvailable() - 1;
					database.getStatement().execute(
							"UPDATE car SET available = '" + cur_number + "' WHERE ID = '" + car.getID() + "'");

					JOptionPane.showMessageDialog(frame, "Buy Successfully! Thank you!", "Success",
							JOptionPane.INFORMATION_MESSAGE);

					// Reload car list
					ResultSet updatedRs = database.getStatement()
							.executeQuery("SELECT * FROM car WHERE available > 0;");
					StringBuilder updatedCarList = new StringBuilder("Available Cars:\n");
					while (updatedRs.next()) {
						updatedCarList.append("ID: ").append(updatedRs.getInt("ID")).append(", Brand: ")
								.append(updatedRs.getString("brand")).append(", Model: ")
								.append(updatedRs.getString("model")).append(", Year: ")
								.append(updatedRs.getInt("yearRelease")).append(", Price: $")
								.append(updatedRs.getDouble("price")).append(", Available: ")
								.append(updatedRs.getInt("available")).append("\n");
					}
					carListArea.setText(updatedCarList.toString());
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(frame, "Error during transaction!", "Error",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
	}
}
