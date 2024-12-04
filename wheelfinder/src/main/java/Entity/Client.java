package main.java.Entity;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.java.Interact.BuyCar;
import main.java.Interact.ChangePassword;
import main.java.Interact.Quit;
import main.java.Interact.ShowUserBuys;
import main.java.Interact.ViewCar;

public class Client extends User {
	private Operation[] operations = new Operation[] { new ViewCar(), new BuyCar(), new ShowUserBuys(1),
			new ChangePassword(), new Quit() };

	public Client() {
		super();
	}

	private JButton[] btns = new JButton[] { new JButton("View Cars"), new JButton("Buy Car"),
			new JButton("Show User Buys"), new JButton("Change Password"),
			new JButton("Quit") };

	public void showList(Database database, User user) {
		JFrame frame = new JFrame("Client Panel");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		JPanel panel = new JPanel(new GridLayout(btns.length, 1, 15, 15));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		for (int i = 0; i < btns.length; i++) {
			final int j = i;
			JButton button = btns[i];
			panel.add(button);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					operations[j].operation(database, Client.this);
				}
			});
		}

		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
}
