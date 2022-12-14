package oop;

public class Product {
	
	//fields
	private int id;
	private String name;
	private double unitPrice;
	private int discountRate;
	private double discountedPrice;
	private Category category;
	
	public Product() {
		category = new Category();
	}
	
	//overloading
	public Product(int id, String name, double unitPrice, int discountRate, Category category) {
		this();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
		this.discountRate = discountRate;
		this.category = category;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}
	public double getDiscountedPrice() {
		return discountedPrice = unitPrice - (unitPrice * discountRate / 100);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
