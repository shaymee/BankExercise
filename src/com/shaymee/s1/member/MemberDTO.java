package com.shaymee.s1.member;

import java.util.ArrayList;

import com.shaymee.s1.book.BookDTO;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String account_num;
	
	private ArrayList<BookDTO> ar;


	public ArrayList<BookDTO> getAr() {
		return ar;
	}
	public void setAr(ArrayList<BookDTO> ar) {
		this.ar = ar;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	
	
	
	
}
