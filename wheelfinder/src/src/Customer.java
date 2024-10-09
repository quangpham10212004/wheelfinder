/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;


public class Customer {
    private String name;
    private String email;
    private String phoneNum;
    private String address;

    public Customer(String name, String email, String phoneNum, String address) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAddress() {
        return address;
    }
    
    public void viewCarDetail(){
        
    }
    
    public void makePurchase(){
        
    }
}
