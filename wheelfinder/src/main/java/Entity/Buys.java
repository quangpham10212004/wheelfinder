package main.java.Entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Buys {
    private String ID;
    private User user;
    private Car car;
    private LocalDateTime time;
    private double totalFee;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy  hh:mm");
    public Buys(){
        time = LocalDateTime.now();
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getTime() {
        return dtf.format(time);
    }

    public void setTime(String ttime) {
        this.time = LocalDateTime.parse(ttime,dtf);
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }
    
}
