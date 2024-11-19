package src.main.Model;
import java.lang.*;
import java.util.*;
public class Cart {
    List<Car> carInCart = new ArrayList<Car>();
    public Cart(){
        
    }
    public Cart(List<Car> list) {
        carInCart = list;
    }

    public void setCarInCart(List<Car> carInCart) {
        this.carInCart = carInCart;
    }

    public List<Car> getCarInCart() {
        return carInCart;
    }
    public void addToCart(){
        
    }
    
    public void removeFromCart(){
        
    }
    public void showAllCart(){
        
    }
    
    
}
