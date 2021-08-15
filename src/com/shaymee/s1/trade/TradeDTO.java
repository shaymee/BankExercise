package com.shaymee.s1.trade;

import java.sql.Date;
import java.util.ArrayList;

import com.shaymee.s1.book.BookDTO;

public class TradeDTO {

	private String account_num;
	private Date trade_date;
	private int trade_amount;
	private int received_paid;
	private double balance;
	
	private BookDTO bookDTO;

	
	public BookDTO getBookDTO() {
		return bookDTO;
	}
	public void setBookDTO(BookDTO bookDTO) {
		this.bookDTO = bookDTO;
	}
	public String getAccount_num() {
		return account_num;
	}
	public void setAccount_num(String account_num) {
		this.account_num = account_num;
	}
	public Date getTrade_date() {
		return trade_date;
	}
	public void setTrade_date(Date trade_date) {
		this.trade_date = trade_date;
	}
	public int getTrade_amount() {
		return trade_amount;
	}
	public void setTrade_amount(int trade_amount) {
		this.trade_amount = trade_amount;
	}
	public int getReceived_paid() {
		return received_paid;
	}
	public void setReceived_paid(int received_paid) {
		this.received_paid = received_paid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
