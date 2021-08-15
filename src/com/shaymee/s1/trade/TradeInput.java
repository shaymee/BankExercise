package com.shaymee.s1.trade;

import java.util.Scanner;

public class TradeInput {

	public int paidSelect(Scanner sc) {
		
		System.out.println("1. 첫번째 계좌");
		System.out.println("2. 두번째 계좌");
		int result = sc.nextInt();
		
		return result;
		
	}
	
	
}
