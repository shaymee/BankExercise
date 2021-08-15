package com.shaymee.s1.book;

import java.util.ArrayList;

import com.shaymee.s1.member.MemberDTO;

public class BookView {

	public void view(MemberDTO memberDTO) {
		
		for(int i=0;i<memberDTO.getAr().size();i++) {
			System.out.println("예금주 ID : "+ memberDTO.getAr().get(i).getId());
			System.out.println("상품명 : "+ memberDTO.getAr().get(i).getProduct_id());
			System.out.println("통장 개설날짜 : "+ memberDTO.getAr().get(i).getOpenning_date());
			System.out.println("계좌번호 : "+ memberDTO.getAr().get(i).getAccount_num());
			System.out.println("잔액 : "+ memberDTO.getAr().get(i).getTradeDTO().getBalance());

			System.out.println("=========================================");
		}
	}
	
}
