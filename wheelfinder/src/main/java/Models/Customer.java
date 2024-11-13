package Models;



public class Customer extends User {
    public Customer(){
        super();
    }
    @Override
    public void showList(){
        System.out.println("\n1. Show Car");
        System.out.println("2. Rent Car");
        System.out.println("3. Return Car");
        System.out.println("4. Show My Rents");
        System.out.println("5. Edit My Data");
        System.out.println("6. Quit");
        
    }
    
}
