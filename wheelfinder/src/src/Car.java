package src;

import java.util.List;

public class Car {
	private String yearOfManufacture;
	private String brand;
	private String type;
	private double price;
	private String model;
        private String color;
        private String status;
        private String energy;
        private int remainingCar;

    public Car(String yearOfManufacture, String brand, String type, double price, String model, String color, String status, String energy, int remainingCar) {
        this.yearOfManufacture = yearOfManufacture;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.model = model;
        this.color = color;
        this.status = status;
        this.energy = energy;
        this.remainingCar = remainingCar;
    }
    public Car() {
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public void setRemainingCar(int remainingCar) {
        this.remainingCar = remainingCar;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getStatus() {
        return status;
    }

    public String getEnergy() {
        return energy;
    }

    public int getRemainingCar() {
        return remainingCar;
    }
    
    
	

}
