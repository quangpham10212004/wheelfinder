
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
            ResultSet rs2 = database.getStatement().executeQuery("Select * from buys where car_id ='"+carID+"'; "); // tim thong tin cua xe vua mua trg buys
            rs2.next();
            int user_id = rs2.getInt("user_id");
            ResultSet rs3 = database.getStatement().executeQuery("Select * from user where id ='"+user_id+"'; "); // tim thong tin cua nguoi mua 
            rs3.next();
            int cur_number = car.getAvailable() - 1;
            
            System.out.println("Your information is:");
            System.out.println("# Full Name: "+rs3.getString("lastName")+" "+rs3.getString("firstName"));
            System.out.println("# Email: "+rs3.getString("email"));
            System.out.println("# Phone Number: "+rs3.getString("phoneNum"));
            System.out.println("# Your Car: ");
            System.out.println("# ID: "+ car.getID());
            System.out.println("# Car's Name: "+ car.getBrand() +" "+car.getModel()+" "+car.getColor());
            System.out.println("# Year Of Manufacture: "+car.getYear());
            System.out.println("# Total Fee: "+car.getPrice());
            database.getStatement().execute("update car set available = '"+cur_number+"' where ID = '"+car.getID()+"'");
        }catch(SQLException e ){
            e.printStackTrace();
        }
    }
}
