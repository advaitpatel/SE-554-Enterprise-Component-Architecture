package edu.depaul.cdm.se.bootstore;

public class ProductSummary {
	public ProductSummary(String productId, String description) {
		super();
		this.productId = productId;
		this.description = description;
	}
	private String productId;
	private String description;
	public ProductSummary() {		
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
