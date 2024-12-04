package main.java.Entity;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.java.Interact.*;
import java.util.Scanner;

public class Admin extends User {
	private Operation[] operations = new Operation[] { new AddNewCar(), new ViewCar(), new UpdateCar(), new DeleteCar(),
			new AddNewAccount(1), new ShowUserBuys(), new ChangePassword(), new ViewAllUser(), new DeleteUser(),
			new Quit() };

	public Admin() {
		super();
	}
	private JButton[] btns = new JButton[] {
			new JButton("Add New Car"),
			new JButton("View Cars"),
			new JButton("Update Car"),
			new JButton("Delete Car"),
			new JButton("Add New Account"),
			new JButton("Show User Buys"),
			new JButton("Change Password"),
			new JButton("View All User"),
			new JButton("DeleteUser"),
			new JButton("Quit")
	};

	public void showList(Database database, User user) {
		// Tạo frame chính
		JFrame frame = new JFrame("Admin Panel");
		frame.setSize(400, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel(new GridLayout(btns.length, 1, 15, 15));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		for (int i=0;i<btns.length;i++) {
			final int j = i;
			JButton button = btns[i];
			panel.add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					operations[j].operation(database, Admin.this);
				}
			});
		}
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
