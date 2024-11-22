package main.java.Interact;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import main.java.Entity.Client;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;


public class AddNewAccount implements Operation {
    private int accType;

    public AddNewAccount(int accType){
       this.accType = accType; 
    }


    public void operation(Database database, Scanner sc, User user){
        System.out.println("Your First Name is :");
        String firstName = sc.next();
        System.out.println("Your Last Name is :");
        String lastName = sc.next();
        System.out.println("Your Phone Number is : ");
        String phoneNum = sc.next();
        System.out.println("What is your email : ");
        String email = sc.next();
        System.out.println("Enter your password :");
        String passwrd = sc.next();
        System.out.println("Retype your password to confirm :");
        String re_passwrd = sc.next();
        
        while(!passwrd.equals(re_passwrd)){
            System.out.println("Password doesn't match");
            System.out.println("Enter your password:");
            passwrd = sc.next();
            System.out.println("Retype your password to confirm:");
            re_passwrd = sc.next();
        }
        try {
            ArrayList <String> emails = new ArrayList<>();
            ResultSet temp = database.getStatement().executeQuery("select email from user;");
            while(temp.next()){
                emails.add(temp.getString("email"));
            }

            if(emails.contains(email)){
                System.out.println("This email is used before\nplease try another email");
                return;
            }

            String insert = "insert into user (firstName, lastName, email,  phoneNum, passwrd, typeNum)\n" + //
                                "values"+"('"+firstName+"','"+lastName+"','"+email+"','"+phoneNum+"','"+passwrd+"','"+accType+"')";
            database.getStatement().execute(insert);
            System.out.println("Created new account successfully!"); 
            if(accType == 0){
                user = new Client();
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(email);
                user.setPhoneNum(phoneNum);
                user.setPassword(passwrd);
                user.showList(database, sc);
            }
                               
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    } 
}
