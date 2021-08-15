package com.shaymee.s1.cont_view;

import java.util.ArrayList;

import com.shaymee.s1.book.BookDTO;
import com.shaymee.s1.member.MemberDTO;
import com.shaymee.s1.product.ProductDTO;
import com.shaymee.s1.trade.TradeDTO;

public class BankView {

	public void view(String message) {
		System.out.println(message);		
	}
	
	
	public void view(ArrayList<MemberDTO> ar) {
		
		int i=0;
		System.out.println("회원 ID : "+ ar.get(i).getId());
		System.out.println("회원 이름 : "+ ar.get(i).getName());
		System.out.println("회원 전화번호 : "+ ar.get(i).getPhone());
		System.out.println("회원 이메일 : "+ ar.get(i).getEmail());
		
		for(i=0;i<ar.size();i++) {
			System.out.println("보유 계좌번호"+(i+1)+" : "+ ar.get(i).getAr().get(i).getAccount_num());
		}
		
		System.out.println("===================================");
		}
	

	public void viewProduct(ArrayList<ProductDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			
			System.out.println("상품 고유번호 : "+ ar.get(i).getProduct_id());
			System.out.println("상품명 : "+ ar.get(i).getProduct_name());
			System.out.println("이자율 : "+ ar.get(i).getInterest());
			System.out.println("판매여부 : "+ ar.get(i).getOnsale());
			
			System.out.println("==========================================");	
		}
		
	}
	
	public void viewBook(ArrayList<BookDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			System.out.println("상품명 : "+ ar.get(i).getProduct_id());
			System.out.println("통장 개설날짜 : "+ ar.get(i).getOpenning_date());
			System.out.println("이자율 : "+ ar.get(i).getTradeDTO().getBalance());
			System.out.println("계좌번호 : "+ ar.get(i).getAccount_num());
			System.out.println("예금주 ID : "+ ar.get(i).getId());
			
			System.out.println("=========================================");
		}
	}
	
	public void viewBalance(ArrayList<TradeDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			System.out.println((i+1)+"번째 계좌 : "+ ar.get(i).getAccount_num());
			System.out.println("잔액 : "+ ar.get(i).getBalance());
			
			System.out.println("==========================================");
			
		}
	}
	
	
}
