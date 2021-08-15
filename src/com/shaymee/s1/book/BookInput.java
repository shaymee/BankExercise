package com.shaymee.s1.book;

import java.util.Scanner;

import com.shaymee.s1.member.MemberDTO;

public class BookInput {

	public MemberDTO inputPw(Scanner sc) {
		System.out.println("== 본인인증 PW 입력 ==");
		String pw = sc.next();
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setPw(pw);
		
		return memberDTO;
		
	}
	
}
