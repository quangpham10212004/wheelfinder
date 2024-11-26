/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.Interact;

import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;
import java.sql.SQLException;

/**
 *
 * @author Quang
 */
public class ChangePassword implements Operation{

    @Override
    public void operation(Database database, Scanner sc, User user) {
        System.out.println("Enter your old password: ");
        String old_passwrd = sc.next();
        if(!old_passwrd.equals(user.getPassword())){
            System.out.println("Password doesn't match");
            return;
        }
        System.out.println("Enter your new password: ");
        String new_passwrd = sc.next();
        System.out.println("Confirm your password: ");
        String con_passwrd = sc.next();
        while(!new_passwrd.equals(con_passwrd)){
            System.out.println("Password doesn't match");
            System.out.println("Enter your new password: ");
            new_passwrd = sc.next();
            System.out.println("Confirm your password: ");
            con_passwrd = sc.next();
        }
        try{
            String update = "update user set passwrd ='"+new_passwrd+"' where email ='"+user.getEmail()+"'"; 
            database.getStatement().execute(update);
            System.out.println("Password changed successfully");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
