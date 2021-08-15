package com.shaymee.s1.book;

import java.sql.Date;
import java.util.ArrayList;

import com.shaymee.s1.member.MemberDTO;
import com.shaymee.s1.product.ProductDTO;
import com.shaymee.s1.trade.TradeDTO;

public class BookDTO {

	private String product_id;
	private Date openning_date;
	private double balance;
	private String account_num;
	private String id;
	
	private ProductDTO productDTO;
	private MemberDTO memberDTO;
	private TradeDTO tradeDTO;
	
	private ArrayList<TradeDTO> ar;

	
	public ArrayList<TradeDTO> getAr() {
		return ar;
	}
	public void setAr(ArrayList<TradeDTO> ar) {
		this.ar = ar;
	}
	public TradeDTO getTradeDTO() {
		return tradeDTO;
	}
	public void setTradeDTO(TradeDTO tradeDTO) {
		this.tradeDTO = tradeDTO;
	}
	public MemberDTO getMemberDTO() {
		return memberDTO;
	}
	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Date getOpenning_date() {
		return openning_date;
	}
	public void setOpenning_date(Date openning_date) {
		this.openning_date = openning_date;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
