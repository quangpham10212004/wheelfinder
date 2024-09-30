package majorProject;

public class User {
	private String name;
	private String birthyear;
	private String address;
	private String phonenumber;
	private String email;

	public User(String name, String birthyear, String address, String phonenumber, String email) {
		this.name = name;
		this.birthyear = birthyear;
		this.address = address;
		this.phonenumber = phonenumber;
		this.email = email;
	}

	public User() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthyear() {
		return birthyear;
	}

	public void setBirthyear(String birthyear) {
		this.birthyear = birthyear;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", birthyear=" + birthyear + ", address=" + address + ", phonenumber="
				+ phonenumber + ", email=" + email + "]";
	}

}
