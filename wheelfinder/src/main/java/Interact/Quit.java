
package main.java.Interact;

import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class Quit implements Operation{

    @Override
    public void operation(Database database, Scanner sc, User user) {
        System.out.println("THANKS FOR VISITING US");
        sc.close();
    }
    
}
