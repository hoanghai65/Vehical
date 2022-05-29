package Model;

public class Truck extends Vehical{
	private int tonnage;
	public Truck(String company, String date, double price, String color, int tonnage) {
		super(company, date, price, color);
		this.tonnage = tonnage;
		// TODO Auto-generated constructor stub
	}
	public int getTonnage() {
		return tonnage;
	}
	public void setTonnage(int tonnage) {
		this.tonnage = tonnage;
	}
	@Override
	public String toString() {
		return "Truck [tonnage=" + tonnage + ", getTonnage()=" + getTonnage() + ", getCompany()=" + getCompany()
				+ ", getDate()=" + getDate() + ", getPrice()=" + getPrice() + ", getColor()=" + getColor()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
