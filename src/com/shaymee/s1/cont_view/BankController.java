package com.shaymee.s1.cont_view;

import java.util.ArrayList;
import java.util.Scanner;

import com.shaymee.s1.book.BookDAO;
import com.shaymee.s1.book.BookDTO;
import com.shaymee.s1.book.BookInput;
import com.shaymee.s1.member.MemberDAO;
import com.shaymee.s1.member.MemberDTO;
import com.shaymee.s1.member.MemberInput;
import com.shaymee.s1.product.ProductDAO;
import com.shaymee.s1.product.ProductDTO;
import com.shaymee.s1.product.ProductInput;
import com.shaymee.s1.trade.TradeDAO;
import com.shaymee.s1.trade.TradeDTO;
import com.shaymee.s1.trade.TradeInput;

public class BankController {
	
	private BankView bankView;
	private BookDAO bookDAO;
	private MemberDAO memberDAO;
	private ProductDAO productDAO;
	private TradeDAO tradeDAO;
	
	private MemberInput memberInput;
	private BookInput bookInput;
	private ProductInput productInput;
	private TradeInput tradeInput;
	
	private Scanner sc;
	
	public BankController() {
		
		bankView = new BankView();
		bookDAO = new BookDAO();
		memberDAO = new MemberDAO();
		productDAO = new ProductDAO();
		tradeDAO = new TradeDAO();	
		
		memberInput = new MemberInput();
		bookInput = new BookInput();
		productInput = new ProductInput();
		tradeInput = new TradeInput();
		
		sc = new Scanner(System.in);
	}

	//1. 회원가입(회원 등록)
	//2. 로그인
	//3. 상품조회
	//4. 거래내역 조회
	//5. 거래내역 등록
	//6. 프로그램 종료
	
	public void start() {
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 회원가입");//완료
			System.out.println("2. 로그인");//완료
			//회원정보 출력항목 추가
			System.out.println("3. 상품 조회");//완료
			// 통장개설항목 추가
			System.out.println("4. MY 통장 조회");//미완
			System.out.println("5. 금융거래");
			// 1)계좌이체, 2)잔액조회
			System.out.println("6. 거래내역 조회");
			System.out.println("7. 프로그램 종료");//완료ㅋㅋ
			
			System.out.println("== 골라 보세요 ==");
			int select = sc.nextInt();
			
			if(select == 1) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO = memberInput.inputMember(sc);
				
				int result = memberDAO.setMember(memberDTO);
				
				if(result > 0) {
					bankView.view("== 회원가입 완료 ==");
				} else {
					bankView.view("== 회원가입 실패 ==");
				}
				
				
			} else if(select ==2) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO = memberInput.inputLogin(sc);
				ArrayList<MemberDTO> ar = memberDAO.getLogin(memberDTO);
				
				if(ar != null) {
					bankView.view("== 로그인 성공 ==");
					bankView.view(ar);
				} else {
					bankView.view("== 로그인 실패 ==");
				}
				
			} else if(select ==3) {
				ArrayList<ProductDTO> ar = productDAO.productInfo();
				bankView.viewProduct(ar);
				
			} else if(select == 4) { //미완
				MemberDTO memberDTO = bookInput.inputPw(sc);
				
				ArrayList<BookDTO> ar = bookDAO.myBookInfo(memberDTO);
				
				bankView.viewBook(ar);
				
			} else if(select == 5) {
				ArrayList<TradeDTO> ar = tradeDAO.balanceInfo(); 
				bankView.viewBalance(ar);
				
				TradeInput tradeInput = new TradeInput();
				bankView.view("== 어떤 계좌로 이체하시겠습니까? ==");				
				int result = tradeInput.paidSelect(sc);
				
							
//				int result2 = tradeDAO.tradePaid(ar.get(result-1));
				

			
				
				
			} else if(select == 6) {
	
			} else {
				System.out.println("==프로그램을 종료합니다==");
				break;			
			}
			
			
			
			
		}
		
		
		
		
	}
	
}
