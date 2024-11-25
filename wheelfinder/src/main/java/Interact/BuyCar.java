package main.java.Interact;
import java.sql.ResultSet;
import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;
import java.sql.SQLException;
import main.java.Entity.Buys;
import main.java.Entity.Car;
public class BuyCar implements Operation {
    public void operation(Database database, Scanner sc, User user){
        System.out.println("Enter Car ID : (-1) to Show All Cars ");
        int carID = sc.nextInt();
        while(carID == -1){
            new ViewCar().operation(database, sc, user);
            System.out.println("Enter Car ID : (-1) to Show All Cars ");
            carID = sc.nextInt();
        }
        try{
            ResultSet rs = database.getStatement().executeQuery("Select * from car where ID = '"+carID+"';");
            rs.next();
            Car car = new Car();
            car.setID(rs.getInt("ID"));
            car.setBrand(rs.getString("brand"));
            car.setModel(rs.getString("model"));
            car.setColor(rs.getString("color"));
            car.setYear(rs.getInt("yearRelease"));
            car.setPrice(rs.getDouble("price"));
            car.setAvailable(rs.getInt("available"));
            if(car.getAvailable() == 0){
                System.out.println("This Car Was Out Of Stock");
                return;
            }
            double totalFee = car.getPrice();
            Buys buy = new Buys();
            String insert = "INSERT INTO buys (user_id, car_id, timeBuy, totalFee)\n "+
                    "VALUES"+"('"+user.getID()+"','"+car.getID()+"','"+buy.getTime()+"','"+totalFee+"')";
            database.getStatement().execute(insert);
            System.out.println("Buy Successfully!!!");
            
            int cur_number = car.getAvailable() - 1;
            database.getStatement().execute("update car set available = '"+cur_number+"' where ID = '"+car.getID()+"'");
        }catch(SQLException e ){
            e.printStackTrace();
        }
    }
}
