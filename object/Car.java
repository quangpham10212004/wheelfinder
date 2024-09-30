package majorProject;

public class Car {
	private String model;
	private String brand;
	private String type;
	private double prize;

	public Car(String model, String brand, String type, double prize) {
		this.model = model;
		this.brand = brand;
		this.type = type;
		this.prize = prize;
	}

	public Car() {
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrize() {
		return prize;
	}

	public void setPrize(double prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", brand=" + brand + ", type=" + type + ", prize=" + prize + "]";
	}

}
