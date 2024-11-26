package main.java.Entity;
import java.util.Scanner;
import main.java.Interact.BuyCar;
import main.java.Interact.ChangePassword;
import main.java.Interact.Quit;
import main.java.Interact.ShowUserBuys;
import main.java.Interact.ViewCar;

public class Client extends User {
    private Operation[] operations = new Operation[]{ new ViewCar(),
    new BuyCar(), new ShowUserBuys(1), new ChangePassword(),new Quit()};
    
    public Client(){
        super();
    }
    public void showList(Database database, Scanner sc){
        System.out.println("\n1. Show Car");
        System.out.println("2. Buy Car");
        System.out.println("3. Show My Buys");
        System.out.println("4. Change Password");
        System.out.println("5. Quit\n");
        int i = sc.nextInt();
        operations[i-1].operation(database, sc, this);
        if(i!= 5)showList(database, sc);
    }
    
    
}
