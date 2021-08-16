package com.shaymee.s1.main;

import java.util.ArrayList;

import java.util.Scanner;

import com.shaymee.s1.book.BookDAO;
import com.shaymee.s1.book.BookDTO;
import com.shaymee.s1.book.BookInput;
import com.shaymee.s1.book.BookView;
import com.shaymee.s1.member.MemberDAO;
import com.shaymee.s1.member.MemberDTO;
import com.shaymee.s1.member.MemberInput;
import com.shaymee.s1.member.MemberView;
import com.shaymee.s1.product.ProductDAO;
import com.shaymee.s1.product.ProductDTO;
import com.shaymee.s1.product.ProductInput;
import com.shaymee.s1.product.ProductView;
import com.shaymee.s1.trade.TradeDAO;
import com.shaymee.s1.trade.TradeDTO;
import com.shaymee.s1.trade.TradeInput;
import com.shaymee.s1.trade.TradeView;

public class BankController {

	private BookDAO bookDAO;
	private MemberDAO memberDAO;
	private ProductDAO productDAO;
	private TradeDAO tradeDAO;
	
	private MemberView memberView;
	private BookView bookView;
	private ProductView productView;
	private TradeView tradeView;
	
	private MemberInput memberInput;
	private BookInput bookInput;
	private ProductInput productInput;
	private TradeInput tradeInput;
	
	private Scanner sc;
	
	public BankController() {
		
		bookDAO = new BookDAO();
		memberDAO = new MemberDAO();
		productDAO = new ProductDAO();
		tradeDAO = new TradeDAO();	
		
		memberInput = new MemberInput();
		bookInput = new BookInput();
		productInput = new ProductInput();
		tradeInput = new TradeInput();
		
		memberView = new MemberView();
		bookView = new BookView();
		productView = new ProductView();
		tradeView = new TradeView();
		
		
		sc = new Scanner(System.in);
	}
	
	
	public void start() { //컨트롤러 start 메서드
	
	boolean check = true;	
		
	while(check) {
		
		MemberDTO mDTO = null;
		
		boolean check1 = true;
		boolean check2 = false;
		
		while(check1) { //로그인-회원가입용 while문
			
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 프로그램 종료");
			System.out.println("== 번호를 선택하세요 ==");
			int select = sc.nextInt();
			
			if(select == 1) {
				MemberDTO memberDTO = memberInput.inputLogin(sc);
				mDTO = memberDAO.getLogin(memberDTO); // mDTO == 로그인 성공한 뒤에도 계속 가지고 가는 MemberDTO 객체
				
				if(mDTO != null) {
					memberView.view("== 로그인 성공 ==");
					memberView.view(mDTO);
					check2 = true;
					break;
					
				} else if(mDTO == null){
					memberView.view("== 로그인 실패 ==");				
				}
				
			} else if(select == 2) {
				MemberDTO memberDTO = memberInput.inputMember(sc);
				int result = memberDAO.setMember(memberDTO);
				
				if(result > 0) {
					memberView.view("== 회원가입 성공 ==");
				} else {
					memberView.view("== 회원가입 실패 ==");
				}
				
			} else if(select == 3){
				check = false;
				break;
			}			
			
		}
				
		
		while(check2) { //로그인 후 while문
			
			System.out.println("0. 신규 계좌 개설");
			System.out.println("1. 개인정보 조회");
			System.out.println("2. My 계좌정보 조회");
			System.out.println("3. 계좌이체");
			System.out.println("4. 거래내역 조회");
			System.out.println("5. 로그아웃");
			System.out.println("6. 프로그램 종료");			
		///////////////////이전꺼 복습//////////////////////
			System.out.println("7. 모든 회원 조회");
			System.out.println("8. 모든 상품 조회");
			
			System.out.println("== 번호를 선택하세요 ==");
			int select = sc.nextInt();
			
			
			if(select == 0) { //신규계좌 개설
				memberView.view("== 어떤 상품으로 계좌를 개설하시겠습니까? ==");
				ArrayList<ProductDTO> ar = productDAO.kindOfproduct();
				productView.view(ar);
				ProductDTO productDTO = productInput.selectProduct(sc, mDTO); 
				ProductDTO pDTO = productDAO.getProductOne(productDTO);
				
				int result = bookDAO.makeBook(pDTO);
				
				if(result > 0) {
					memberView.view("== 신규 계좌 개설 성공 ==");
				} else {
					memberView.view("== 계좌 개설 실패 ==");
				}				
				
			} else if(select == 1) { //개인정보 조회
				memberView.view(mDTO);
				
			} else if(select == 2) { //내 계좌들 정보 조회(잔액조회 포함) //미완
				
				MemberDTO memberDTO = bookDAO.myBookInfo(mDTO);
				bookView.view(memberDTO);
				
			} else if(select == 3) { //계좌이체
				TradeInput tradeInput = new TradeInput();
				TradeDTO tradeDTO= tradeInput.paidInput(sc);
				
				System.out.println("== 얼마를 보내시겠습니까? ==");
				int paid = -(sc.nextInt());
				ArrayList<TradeDTO> ar = tradeDAO.accountReport(tradeDTO);
				
				int result = tradeDAO.tradePaid(ar, paid);
				
				if(result > 0) {
					memberView.view("== 이체 성공 ==");
				} else {
					memberView.view("== 이체 실패 ==");
				}

			} else if(select == 4) { //거래내역 조회 //미완
				MemberDTO memberDTO = bookDAO.myBookInfo(mDTO);
				MemberDTO memDTO = tradeDAO.tradeInfo(memberDTO);
				tradeView.view(memDTO);
				
			} else if(select == 5) { //로그아웃
				memberView.view("== 로그아웃 되셨습니다 ==");
				break;				
				
			} else if(select == 6) { //프로그램 종료
				memberView.view("== 프로그램을 종료합니다 ==");
				check = false;
				break;
				
			} else if(select == 7) { //전체회원조회
				ArrayList<MemberDTO> ar = memberDAO.memberAll();
				memberView.view(ar);
				
			} else if(select == 8) { //전체상품조회
				ArrayList<ProductDTO> ar = productDAO.kindOfproduct();
				productView.view(ar);
			}
			
		}
	}
	}
}


//MemberDTO memberDTO = memberDAO.member_books(mDTO);
//MemberDTO mDTO1 = bookDAO.book_trades1(memberDTO, memberDTO.getAr().get(0));
//bookView.view(mDTO1, 0);
//
//System.out.println("=============================================");
//
//MemberDTO mDTO2 = bookDAO.book_trades2(memberDTO, memberDTO.getAr().get(1));
//bookView.view(mDTO2, 1);

//tradeDAO.accountReport(tradeDTO);// 계좌별 거래내역 묶음
