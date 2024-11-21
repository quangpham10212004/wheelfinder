/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Entity.Database;
import Entity.User;
import java.util.Scanner;

/**
 *
 * @author Quang
 */
public interface Operation {
    public void operation(Database database, Scanner sc , User user);
}
