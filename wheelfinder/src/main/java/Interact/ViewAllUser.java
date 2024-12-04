package main.java.Interact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import main.java.Entity.Admin;
import main.java.Entity.Client;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class ViewAllUser implements Operation {

    @Override
    public void operation(Database database, User user) {
        JFrame frame = new JFrame("View All Users");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Tabs for separating clients and admins
        JTabbedPane tabbedPane = new JTabbedPane();

        // Table for clients
        DefaultTableModel clientModel = new DefaultTableModel();
        clientModel.setColumnIdentifiers(new String[]{"ID", "First Name", "Last Name", "Phone Number", "Email", "Password"});
        JTable clientTable = new JTable(clientModel);
        JScrollPane clientScrollPane = new JScrollPane(clientTable);

        // Table for admins
        DefaultTableModel adminModel = new DefaultTableModel();
        adminModel.setColumnIdentifiers(new String[]{"ID", "First Name", "Last Name", "Phone Number", "Email", "Password"});
        JTable adminTable = new JTable(adminModel);
        JScrollPane adminScrollPane = new JScrollPane(adminTable);

        // Load data
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            ResultSet rsClients = database.getStatement().executeQuery("SELECT * FROM user WHERE typeNum = '0';");
            while (rsClients.next()) {
                Client client = new Client();
                client.setID(rsClients.getInt("id"));
                client.setFirstName(rsClients.getString("firstName"));
                client.setLastName(rsClients.getString("lastName"));
                client.setPhoneNum(rsClients.getString("phoneNum"));
                client.setEmail(rsClients.getString("email"));
                client.setPassword(rsClients.getString("passwrd"));
                clients.add(client);

                clientModel.addRow(new Object[]{
                        client.getID(),
                        client.getFirstName(),
                        client.getLastName(),
                        client.getPhoneNum(),
                        client.getEmail(),
                        client.getPassword()
                });
            }

            ResultSet rsAdmins = database.getStatement().executeQuery("SELECT * FROM user WHERE typeNum = '1';");
            while (rsAdmins.next()) {
                Admin admin = new Admin();
                admin.setID(rsAdmins.getInt("id"));
                admin.setFirstName(rsAdmins.getString("firstName"));
                admin.setLastName(rsAdmins.getString("lastName"));
                admin.setPhoneNum(rsAdmins.getString("phoneNum"));
                admin.setEmail(rsAdmins.getString("email"));
                admin.setPassword(rsAdmins.getString("passwrd"));
                admins.add(admin);

                adminModel.addRow(new Object[]{
                        admin.getID(),
                        admin.getFirstName(),
                        admin.getLastName(),
                        admin.getPhoneNum(),
                        admin.getEmail(),
                        admin.getPassword()
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Error loading user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        // Add tabs
        tabbedPane.addTab("Clients", clientScrollPane);
        tabbedPane.addTab("Admins", adminScrollPane);

        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
