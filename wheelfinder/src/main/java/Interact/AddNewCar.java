package main.java.Interact;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;


public class AddNewCar implements Operation{
    public void operation(Database database, Scanner sc, User user){
        System.out.println("Enter brand name: ");
        String brand = sc.next();
        System.out.println("Enter model: ");
        String model = sc.next();
        System.out.println("Enter color: ");
        String color = sc.next();
        System.out.println("Enter year release: ");
        String yearRelease = sc.next();
        
        System.out.println("Enter this car's price: ");
        
        double price = Double.parseDouble(sc.next());
        System.out.println("Enter the number of this car: ");
        int available = sc.nextInt();
        try {
            String insert = "insert into car(brand, model, color, yearRelease, price, available)\n" + //
                                "values "+"('"+brand+"','"+model+"','"+color+"','"+yearRelease+"','"+price+"','"+available+"')";
            database.getStatement().execute(insert);
            System.out.println("Car Added To System!");                                   
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
