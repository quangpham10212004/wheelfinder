package main.java.Entity;
import java.util.Scanner;
import main.java.Interact.ViewCar;

public class Client extends User {
    private Operation[] operations = new Operation[]{ new ViewCar()};
    
    public Client(){
        super();
    }
    public void showList(Database database, Scanner sc){
        System.out.println("\n1. Show Car");
        System.out.println("2. Buy Car");
        System.out.println("3. Return Car");
        System.out.println("4. Show My Buys");
        System.out.println("5. Edit My Data");
        System.out.println("6. Quit");
    }
}
