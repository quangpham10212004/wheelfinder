package main.java.Main;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import main.java.Entity.Admin;
import main.java.Entity.Client; 
import main.java.Entity.Database;
import main.java.Entity.User;
import main.java.Interact.AddNewAccount;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        Scanner sc = new Scanner(System.in);

//        System.out.println("WELCOME TO WHEELFINDER\n");
        System.out.println("Enter your email:\nOr Enter (-1) to Create New Account:\n\n  ");
        String email = sc.next();
        if(email.equals("-1")){
            new AddNewAccount(0).operation(database, sc, null);// trong java co the goi truc tiep nhu nay va no se tra ve 1 doi tuong dc tao ra
            return;
        }
        System.out.println("Enter your password: ");
        String password = sc.next();
        ArrayList<User> users = new ArrayList<>();
        try{
            String select = "Select * FROM user;";
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                User user;
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String em = rs.getString("email");
                String phoneNum = rs.getString("phoneNum");
                String pass = rs.getString("passwrd");
                int type = rs.getInt("typeNum");
                if(type == 0){
                    user = new Client();
                }else if(type == 1){
                    user = new Admin();
                }else{
                    System.out.println("Account does not exist :(");
                    return;
                }
                
                user.setID(id);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(em);
                user.setPhoneNum(phoneNum);
                user.setPassword(pass);
                users.add(user);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        boolean ok = false; // flag de check xem tk vs mk  co hop le khong
        for(User us : users){
            if(us.getEmail().equals(email) && us.getPassword().equals(password)){ // check xem tk da co trong dtb hay chua
                ok = true;
                System.out.println("Welcome "+us.getFirstName()+" !!!");
                us.showList(database, sc);
            }
        }
        if(ok == false){
            System.out.println("Your email or password is not valid :(");
            sc.close();
        }
      

    }
}
