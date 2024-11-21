/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Scanner;

import Interact.AddNewAccount;
import Interact.AddNewCar;
import Interact.DeleteCar;
import Interact.UpdateCar;
import Interact.ViewCar;


/**
 *
 * @author Quang
 */
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
        System.out.println("7. Quit\n");
        
        int i = sc.nextInt();
        operations[i-1].operation(database, sc, this);
        showList(database, sc);
        
    }
}
