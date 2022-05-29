package Model;

public class Car extends Vehical{
	
	private int numberOfSeats;
	private String engineType;
	
	public Car(String company, String date, double price, String color,int numberOfSeats, String engineType) {
		super(company, date, price, color);
		this.numberOfSeats = numberOfSeats;
		this.engineType = engineType;
		// TODO Auto-generated constructor stub
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	@Override
	public String toString() {
		return "Car [numberOfSeats=" + numberOfSeats + ", engineType=" + engineType + ", getNumberOfSeats()="
				+ getNumberOfSeats() + ", getEngineType()=" + getEngineType() + ", getCompany()=" + getCompany()
				+ ", getDate()=" + getDate() + ", getPrice()=" + getPrice() + ", getColor()=" + getColor()
				+ "]";
	}
	

}
