package Interact;

import java.util.Scanner;

import Models.Database;
import Models.User;

public interface Operation {
    public void operation(Database database, Scanner s, User user);
}
