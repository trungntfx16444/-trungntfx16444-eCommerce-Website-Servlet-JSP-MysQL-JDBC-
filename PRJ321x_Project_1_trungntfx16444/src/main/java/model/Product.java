package model;

public class Product {
	private int id;
	private String name;
	private String description;
	private double price;
	private String src;//location of image of product
	private String type; // type of product (for future purpose)
	private String brand;//produce's category(for future use)
	private int number;
	
	public Product() {
		super();
	}

	public Product(int id, String name, String description, double price, String src, String type, String brand,
			int number) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.src = src;
		this.type = type;
		this.brand = brand;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public String getSrc() {
		return src;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public int getNumber() {
		return number;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", src="
				+ src + ", type=" + type + ", brand=" + brand + ", number=" + number + "]";
	}
	
	
}
