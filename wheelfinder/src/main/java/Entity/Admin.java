
package main.java.Entity;


import java.util.Scanner;
import main.java.Interact.AddNewAccount;
import main.java.Interact.AddNewCar;
import main.java.Interact.DeleteCar;
import main.java.Interact.UpdateCar;
import main.java.Interact.ViewCar;


public class Admin extends User {
    private Operation[] operations = new Operation[] { new AddNewCar(),
        new ViewCar(),new UpdateCar(),new DeleteCar(),new AddNewAccount(1) }; // 1 phan tu duy nhat


    public Admin(){
        super();
    }
    
    public void showList(Database database , Scanner sc){
        System.out.println("\n1. Add New Car");
        System.out.println("2. View Car");
        System.out.println("3. Update Car");
        System.out.println("4. Delete Car");
        System.out.println("5. Add New Admin");
        // System.out.println("6. Show History");
//        System.out.println("7. Show User's Buys");
        System.out.println("8. Quit\n");
        
        int i = sc.nextInt();
        operations[i-1].operation(database, sc, this);
        showList(database, sc);
        
    }
}
