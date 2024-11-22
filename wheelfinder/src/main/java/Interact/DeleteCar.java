package main.java.Interact;

import java.sql.SQLException;
import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;


public class DeleteCar implements Operation {
    public void operation(Database database, Scanner sc, User user){
        System.out.println("Enter ID Of The Car You Wan To Delete: (-1) to Show All Cars");
        int id= sc.nextInt();
        while(id == - 1){
            new ViewCar().operation(database, sc, user);
            System.out.println("Enter ID Of The Car You Wan To Delete: (-1) to Show All Cars");
            id = sc.nextInt();
        }

        try {
            String update = "delete from car where ID = '"+id+"'";
            database.getStatement().execute(update);
            System.out.println("Car Deleted Successfully!! ");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
