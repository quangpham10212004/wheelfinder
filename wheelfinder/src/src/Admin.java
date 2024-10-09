package src;

public class Admin {
    private String name;
    private String email;
    private String hotline;
    
    public Admin(String name, String email, String hotline) {
            this.name = name;
            this.email = email;
            this.hotline = hotline;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHotline() {
        return hotline;
    }
	
    public void addCarToSystem(Inventory inventory, Car car) {
       inventory.addCar(car); // Gọi phương thức addCar của Inventory để thêm xe
       System.out.println("Car added to inventory: " + car);
    }

    public void removeCar(Inventory inventory, Car car) {
        inventory.removeCar(car); // Gọi phương thức removeCar của Inventory để xóa xe
        System.out.println("Car removed from inventory: " + car);
    }

    void updateCarDetail() {

    }
    
    void getCarCount(){
        
    }
	
}
