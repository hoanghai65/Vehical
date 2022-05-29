package Model;

public abstract class Vehical {
	private String company;
	private String date;
	private double price;
	private String color;
	
	public Vehical(String company, String date, double price, String color) {
		super();
		this.company = company;
		this.date = date;
		this.price = price;
		this.color = color;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
