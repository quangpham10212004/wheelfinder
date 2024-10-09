
package src;
import java.util.*;
import java.lang.*;
public class Inventory {
    private List<Car> CarInInve = new ArrayList<Car>();
    private int numOfCarInInve;

    public Inventory() {
    }
    public Inventory(List<Car> list){
        CarInInve = list;
    }
    
    public void setCarInInve(List<Car> CarInInve) {
        this.CarInInve = CarInInve;
    }

    public List<Car> getCarInInve() {
        return CarInInve;
    }

    public int getNumOfCarInInve() { // so luong xe con trogn inve
        return CarInInve.size();
    }
    
    public void addCar(Car newCar){ // ham them xe
        CarInInve.add(newCar);
    }
    
    public void removeCar(Car reCar){
        CarInInve.remove(reCar);
    }
    
    
}
