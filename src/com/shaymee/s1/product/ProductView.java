package com.shaymee.s1.product;

import java.util.ArrayList;

public class ProductView {

	public void view(ArrayList<ProductDTO> ar) {
		
		for(int i=0;i<ar.size();i++) {
			
			System.out.println("상품 고유번호 : "+ ar.get(i).getProduct_id());
			System.out.println("상품명 : "+ ar.get(i).getProduct_name());
			System.out.println("이자율 : "+ ar.get(i).getInterest());
			System.out.println("판매여부 : "+ ar.get(i).getOnsale());
			
			System.out.println("==========================================");	
		}
		
	}
	
}
