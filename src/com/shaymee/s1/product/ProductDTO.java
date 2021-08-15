package com.shaymee.s1.product;

public class ProductDTO {

	private String product_id;
	private String product_name;
	private double interest;
	private String onsale;
	
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public String getOnsale() {
		return onsale;
	}
	public void setOnsale(String onsale) {
		this.onsale = onsale;
	}
	
	
	
}
