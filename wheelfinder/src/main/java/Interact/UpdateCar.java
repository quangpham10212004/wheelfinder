package main.java.Interact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import main.java.Entity.Car;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;


public class UpdateCar implements Operation{
    public void operation(Database database, Scanner sc, User user){
        System.out.println("Enter Car ID : (-1) to Show All Car");
        int  cur_id = sc.nextInt();
        while(cur_id == -1){
            new ViewCar().operation(database, sc, user);
            System.out.println("Enter Car ID : (-1) to Show All Car");
            cur_id = sc.nextInt();
        }
        try {
            ResultSet rs = database.getStatement().executeQuery("select * from car\n" + //
                                "where ID = '"+cur_id+"';");
            rs.next();
            Car car = new Car();
            car.setBrand(rs.getString("brand"));
            car.setModel(rs.getString("model"));
            car.setColor(rs.getString("color"));
            car.setYear(rs.getInt("yearRelease"));
            car.setPrice(rs.getDouble("price"));
            car.setAvailable(rs.getInt("available"));      
            
            System.out.println("Enter (-1) to enter old value");
            System.out.println("Enter New Branch: (-1) "+car.getBrand());
            String brand = sc.next();
            if(brand.equals("-1")) brand = car.getBrand();
            System.out.println("Enter New Model: (-1) " + car.getModel());
            String model = sc.next();
            if(model.equals("-1")) model = car.getModel();
            System.out.println("Enter New Color: (-1) " + car.getColor());
            String color = sc.next();
            if(color.equals("-1")) color = car.getColor();
            System.out.println("Enter Year Of Manufacture: (-1) "+car.getYear());
            int yearRelease = sc.nextInt();
            if(yearRelease == -1) yearRelease = car.getYear();
            System.out.println("Enter New Price: (-1) "+car.getPrice());
            double price = sc.nextDouble();
            if(price == -1) price = car.getPrice();
            System.out.println("Enter New Status: (-1) "+car.getAvailable());
            int available = sc.nextInt();
            if(available == -1) available = car.getAvailable();
            String update = "update car\n" + 
            "set brand = '"+brand+"', model = '"+model+"', color ='"+color+"',yearRelease = '"+yearRelease+"',price = '"+price+"',available ='"+available+"'" + 
                                    "where id ='"+cur_id+"' ";
            database.getStatement().execute(update);
            System.out.println("Updated!");
            


        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }


    }
}
