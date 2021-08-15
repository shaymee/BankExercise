package com.shaymee.s1.member;

import java.util.Scanner;

public class MemberInput {

	public MemberDTO inputMember(Scanner sc) {
		
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("== ID 입력 ==");
		String id = sc.next();
		memberDTO.setId(id);
		System.out.println("== PW 입력 ==");
		String pw = sc.next();
		memberDTO.setPw(pw);
		System.out.println("== 이름 입력 ==");		
		String name = sc.next();
		memberDTO.setName(name);
		System.out.println("== 전화번호 입력 ==");
		String phone = sc.next();
		memberDTO.setPhone(phone);
		System.out.println("== 이메일 입력 ==");
		String email = sc.next();
		memberDTO.setEmail(email);
		
		return memberDTO;

	}
	
	public MemberDTO inputLogin(Scanner sc) {
		MemberDTO memberDTO = new MemberDTO();
		
		System.out.println("== 로그인 ID 입력 ==");
		String id = sc.next();
		memberDTO.setId(id);
		System.out.println("== 로그인 PW 입력 ==");
		String pw = sc.next();
		memberDTO.setPw(pw);
		
		return memberDTO;
		
		
	}
	
}
