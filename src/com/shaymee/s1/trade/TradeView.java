package com.shaymee.s1.trade;

import java.util.ArrayList;

import com.shaymee.s1.member.MemberDTO;

public class TradeView {
	
	public void view(MemberDTO memberDTO) {
		
		for(int i=0;i<memberDTO.getAr().size();i++) {
			
			System.out.println(memberDTO.getAr().get(i).getProduct_id());
			System.out.println(memberDTO.getAr().get(i).getTradeDTO().getAccount_num());
			System.out.println(memberDTO.getAr().get(i).getTradeDTO().getTrade_date());
			System.out.println(memberDTO.getAr().get(i).getTradeDTO().getTrade_amount());
			System.out.println(memberDTO.getAr().get(i).getTradeDTO().getReceived_paid());
			System.out.println(memberDTO.getAr().get(i).getTradeDTO().getBalance());
			
			System.out.println("=========================================================");
						
		}
	}
	
}
