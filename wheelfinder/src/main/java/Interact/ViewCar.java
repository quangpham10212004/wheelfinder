package main.java.Interact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import main.java.Entity.Car;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;



public class ViewCar implements Operation{
    @Override
    public void operation(Database database, Scanner sc, User user){
        System.out.println();
        String select = "Select * from car;";
        ArrayList<Car> cars = new ArrayList<>();
        try {
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                Car car = new Car();
                car.setID(rs.getInt("ID"));
                car.setBrand(rs.getString("brand"));
                car.setModel(rs.getString("model"));
                car.setColor(rs.getString("color"));
                car.setYear(rs.getInt("yearRelease"));
                car.setPrice(rs.getDouble("price"));
                car.setAvailable(rs.getInt("available"));
                cars.add(car);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Car cur_car : cars){
            
            System.out.println("ID:\t" + cur_car.getID());
            System.out.println("Brand:\t"+cur_car.getBrand());
            System.out.println("Model:\t"+cur_car.getModel());
            System.out.println("Color:\t"+cur_car.getColor());
            System.out.println("Year Of Manufacture:\t"+cur_car.getYear());
            System.out.println("Price:\t"+cur_car.getPrice()+"$");
            
            if(cur_car.getAvailable() >= 1){
                System.out.println("Current Number Of This Car: "+cur_car.getAvailable());
            }
            else{
                System.out.println("Current Status: Ran Out Of Stock ");
            }
            System.out.println("---------------------------------\n");
        }
    }
}
