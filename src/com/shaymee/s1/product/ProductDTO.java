package com.shaymee.s1.product;

import com.shaymee.s1.member.MemberDTO;

public class ProductDTO {

	private int product_id;
	private String product_name;
	private double interest;
	private String onsale;
	
	private MemberDTO memberDTO; //이건 넣기 싫었는데
	
	
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
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
