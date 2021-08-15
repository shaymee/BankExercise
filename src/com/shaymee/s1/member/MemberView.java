package com.shaymee.s1.member;

public class MemberView {

	public void view(MemberDTO memberDTO) { //개인회원 정보 출력 메서드
		
		System.out.println("회원 ID : "+ memberDTO.getId());
		System.out.println("회원 이름 : "+ memberDTO.getName());
		System.out.println("회원 EMAIL : "+ memberDTO.getEmail());
		System.out.println("회원 전화번호 : "+ memberDTO.getPhone());
		
		System.out.println("===================================");
	}
	
	
	public void view(String message) { //메세지 출력 메서드
		System.out.println(message);		
	}
	
}
