package main.java.Interact;

import java.util.ArrayList;
import java.util.Scanner;

import main.java.Entity.Admin;
import main.java.Entity.Client;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ViewAllUser implements Operation {

	@Override
	public void operation(Database database, Scanner sc, User user) {
		System.out.println();
		ArrayList<Client> clients = new ArrayList<>();
		ArrayList<Admin> admins = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery("select * from user where typeNum = '0';");
			while(rs.next()){
				Client client = new Client();
				client.setID(rs.getInt("id"));
				client.setFirstName(rs.getString("firstName"));
				client.setLastName(rs.getString("lastName"));
				client.setPassword(rs.getString("passwrd"));
				client.setPhoneNum(rs.getString("phoneNum"));
				client.setEmail(rs.getString("email"));
				clients.add(client);
			}

			ResultSet rs1 = database.getStatement().executeQuery("select * from user where typeNum = '1';");
			while(rs1.next()){
				Admin admin = new Admin();
				admin.setID(rs1.getInt("id"));
				admin.setFirstName(rs1.getString("firstName"));
				admin.setLastName(rs1.getString("lastName"));
				admin.setPassword(rs1.getString("passwrd"));
				admin.setPhoneNum(rs1.getString("phoneNum"));
				admin.setEmail(rs1.getString("email"));
				admins.add(admin);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Customer List:\n");
		for(Client i : clients){
			System.out.println("ID:\t"+i.getID());
			System.out.println("First Name:\t"+i.getFirstName());
			System.out.println("Last Name:\t"+i.getLastName());
			System.out.println("Phone Number:\t"+i.getPhoneNum());
			System.out.println("Email:\t"+i.getEmail());
			System.out.println("Password:\t"+i.getPassword());
			System.out.println("---------------------------------\n");
		}

		System.out.println("Admin List:\n");
		for(Admin i : admins){
			System.out.println("ID:\t"+i.getID());
			System.out.println("First Name:\t"+i.getFirstName());
			System.out.println("Last Name:\t"+i.getLastName());
			System.out.println("Phone Number:\t"+i.getPhoneNum());
			System.out.println("Email:\t"+i.getEmail());
			System.out.println("Password:\t"+i.getPassword());
			System.out.println("---------------------------------\n");
		}
	}
	
}
