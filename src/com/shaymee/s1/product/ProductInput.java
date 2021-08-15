package com.shaymee.s1.product;

import java.util.Scanner;

import com.shaymee.s1.member.MemberDTO;

public class ProductInput {

	public ProductDTO selectProduct(Scanner sc, MemberDTO memberDTO) {
		System.out.println("== 개설할 '상품 고유번호'를 입력하세요 ==");
		int product_id = sc.nextInt(); // 실수로 Oracle에서 PRODUCT_ID를 varchar2 타입으로 만들었음
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_id(product_id);
		productDTO.setMemberDTO(memberDTO);
		
		return productDTO;
		
	}
}
