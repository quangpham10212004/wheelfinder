package main.java.Interact;

import java.util.Scanner;
import main.java.Entity.Database;
import main.java.Entity.Operation;
import main.java.Entity.User;

public class Quit implements Operation {

    @Override
    public void operation(Database database, User user) {
        System.out.println("THANKS FOR VISITING US");
        try {
            if (database != null && database.getConnection() != null && !database.getConnection().isClosed()) {
                database.getConnection().close();
                System.out.println("Database connection closed successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error closing the database connection: " + e.getMessage());
        }
    }
}
