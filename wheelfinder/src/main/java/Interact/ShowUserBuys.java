package main.java.Interact;

import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.Entity.Buys;

public class ShowUserBuys implements Operation{
    private int typeNum;
    
    public ShowUserBuys(int userID){
        this.typeNum = userID;
    }
    
    public ShowUserBuys(){}
    public int getTypeNum() {
        return typeNum;
    }
    
    
    
    public void operation(Database database, Scanner sc , User user){
        try{
            String select;
            int tn = this.getTypeNum();
            if(tn == 0){
                System.out.println("Enter User ID:" );
                int uID = sc.nextInt();
                select = "select * from buys where user_id = '"+uID+"';";
            }
            else{
                select = "select * from buys where user_id = '"+user.getID()+"';";
            }
            ResultSet rs = database.getStatement().executeQuery(select);
            double total = 0;
            ArrayList<Integer> carIDs = new ArrayList<>();
            ArrayList<String> times = new ArrayList<>();
            if(!rs.next()){
                System.out.println("You have not bought a car yet ");
                return;
            }
            while(rs.next()){
                int car_id = rs.getInt("car_id");
                carIDs.add(car_id);
                times.add(rs.getString("timeBuy"));
                total+=(rs.getDouble("totalFee"));
            }
            ResultSet rs3 = database.getStatement().executeQuery("Select * from user where id ='"+user.getID()+"'; "); // tim thong tin cua nguoi mua 
            rs3.next();
            System.out.println("Client's information is:");
            System.out.println("# Full Name: "+rs3.getString("lastName")+" "+rs3.getString("firstName"));
            System.out.println("# Email: "+rs3.getString("email"));
            System.out.println("# Phone Number: "+rs3.getString("phoneNum"));
            System.out.println("# Your Cars: ");
            System.out.println("---------------------------------\n");
            int dem = 0;
            for(Integer id : carIDs){
                ResultSet rs1 = database.getStatement().executeQuery("select * from car where ID = '"+id+"';");
                rs1.next();
                System.out.println("# ID: "+ rs1.getInt("ID"));
                System.out.println("# Car's Name: "+ rs1.getString("brand") +" "+rs1.getString("model")+" "+rs1.getString("color"));
                System.out.println("# Year Of Manufacture: "+rs1.getString("yearRelease"));
                System.out.println("# Price: "+rs1.getDouble("price")+"$");
                System.out.println("# Bought At: "+times.get(dem));
                dem++;
                System.out.println("---------------------------------\n");
            }
            System.out.println("Your Total Fee is: "+total+"$");    
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
}
