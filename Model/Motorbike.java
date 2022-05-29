package Model;

public class Motorbike extends Vehical{
	private String wattage;

	public Motorbike(String company, String date, double price, String color,String wattage) {
		super(company, date, price, color);
		this.wattage = wattage;
		// TODO Auto-generated constructor stub
	}

	public String getWattage() {
		return wattage;
	}

	public void setWattage(String wattage) {
		this.wattage = wattage;
	}

	@Override
	public String toString() {
		return "Motorbike [wattage=" + wattage + ", getWattage()=" + getWattage() + ", getCompany()=" + getCompany()
				+ ", getDate()=" + getDate() + ", getPrice()=" + getPrice() + ", getColor()=" + getColor()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
