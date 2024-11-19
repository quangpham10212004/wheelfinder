package src.main.Model;

import java.util.Scanner;
import src.main.Model.Database;

public interface Operation {
	
	public void operation(Database database, Scanner s, User user);

}
