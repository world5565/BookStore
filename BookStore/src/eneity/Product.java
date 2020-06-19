package eneity;

public class Product {
	private int id;
	private String name;
	private double price;
	private String imgurl;
	private String txturl;
	private String description;
	
	public Product() {
		this.id = 0;
		this.name = "";
		this.price = 0.0;
		this.imgurl = "";
		this.description = "";
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getTxturl() {
		return txturl;
	}

	public void setTxturl(String txturl) {
		this.txturl = txturl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
