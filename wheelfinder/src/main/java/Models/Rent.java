package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Rent {
    private int ID;
    private User user;
    private Car car;
    private LocalDateTime dateTime;
    private int hours;
    private double total;
    private String status;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm");
    
    
    public Rent(){
        dateTime = LocalDateTime.now();
    }


    public int getID() {
        return ID;
    }


    public User getUser() {
        return user;
    }


    public Car getCar() {
        return car;
    }


    public String getDateTime() {
        return dtf.format(dateTime);
    }


    public int getHours() {
        return hours;
    }


    public double getTotal() {
        return total;
    }


    public String getStatus() {
        return status;
    }
    
    public void setID(int iD) {
        ID = iD;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public void setCar(Car car) {
        this.car = car;
    }


    public void setDateTime(String time) {
        this.dateTime = LocalDateTime.parse(time, dtf);
    }


    public void setHours(int hours) {
        this.hours = hours;
    }


    public void setTotal(double total) {
        this.total = total;
    }


    public void setStatus(String status) {
        this.status = status;
    }
}
