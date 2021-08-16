package com.shaymee.s1.trade;

import java.util.Scanner;

import com.shaymee.s1.book.BookDTO;

public class TradeInput {

	public TradeDTO paidInput(Scanner sc) {
		System.out.println("== 인출할 계좌의 계좌번호를 입력하세요 ('-' 포함) ==");
		String account = sc.next();
		
		TradeDTO tradeDTO = new TradeDTO();
		tradeDTO.setAccount_num(account);
		
		return tradeDTO;		
		
	}
	
	
}
