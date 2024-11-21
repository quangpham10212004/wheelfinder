/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Scanner;

import javax.xml.crypto.Data;

/**
 *
 * @author Quang
 */
public class Client extends User {
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
