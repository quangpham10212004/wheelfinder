package Models;



public abstract class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;// sdt user
    private String password;
    private String address; // dia chi nha

    public User(){}

    public int getID(){ return ID;}
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String location){
        this.address = location;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void showList();

}
