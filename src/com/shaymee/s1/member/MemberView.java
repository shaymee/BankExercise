package com.shaymee.s1.member;

import java.util.ArrayList;

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
	
	
	public void view(ArrayList<MemberDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
		System.out.println("회원 ID : "+ ar.get(i).getId());
		System.out.println("회원 이름 : "+ ar.get(i).getName());
		System.out.println("회원 EMAIL : "+ ar.get(i).getEmail());
		System.out.println("회원 전화번호 : "+ ar.get(i).getPhone());
		
		System.out.println("===================================");
		
		}
	}
	
}
