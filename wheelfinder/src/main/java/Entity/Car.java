
package main.java.Entity;

public class Car {

    private int ID;
    private String brand;
    private String model;
    private String color;
    private int yearRelease;// nsx
    private double price;
    private int available;  //0 : het hang // new :: bieu thi cho sluong hang
                            //1 : con hang
    public Car() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return yearRelease;
    }

    public void setYear(int year) {
        this.yearRelease = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getAvailable() {
        return available;
    }

    

    
    
}
