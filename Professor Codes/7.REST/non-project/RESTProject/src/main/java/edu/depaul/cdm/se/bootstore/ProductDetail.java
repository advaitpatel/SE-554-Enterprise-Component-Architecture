package edu.depaul.cdm.se.bootstore;

public class ProductDetail {
	private String name;
	private String sku;
	private String height;
	private String lining;
	private String colors;
	private double price;
	private String features;
	
	public ProductDetail() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getLining() {
		return lining;
	}
	public void setLining(String lining) {
		this.lining = lining;
	}
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
}
