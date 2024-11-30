package main.java.Interact;

import java.sql.SQLException;
import java.util.Scanner;

import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class DeleteUser implements Operation{
    public void operation(Database database, Scanner sc, User user){
        System.out.println("Enter ID Of The User: (-1) to View All Users");
        int id = sc.nextInt();
        int cur_id = user.getID();  
        while(id == -1 || id == cur_id){
            if(id == -1){
                new ViewAllUser().operation(database, sc, user);
            }
            if(id == cur_id){
                System.out.println("You Can Not Delete Yourself");
            }
            System.out.println("Enter ID Of The User: (-1) to View All Users");
            id = sc.nextInt();
        } 
        try{
            String del = "delete from user where id ='"+id+"'";
            database.getStatement().execute(del);
            System.out.println("User Deleted Successfully!!");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
}
