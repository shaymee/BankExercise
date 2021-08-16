package com.shaymee.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shaymee.s1.book.BookDTO;
import com.shaymee.s1.util.BankConnect;

public class MemberDAO { 

	private BankConnect dbConnect;
	
	public MemberDAO() {
		dbConnect = new BankConnect();
	}
	
	public MemberDTO member_books(MemberDTO memberDTO) { // 멤버 1 : 계좌 N 관계 메소드
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		MemberDTO mDTO = null;		
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT B.ID, B.PRODUCT_ID, B.OPENING_DATE, B.ACCOUNT_NUM "
					+ " FROM MEMBER M inner join BOOK B "
					+ " ON (M.ID = B.ID) "
					+ " WHERE M.ID = ? ";
			
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			
			rs = st.executeQuery();
			
			ArrayList<BookDTO> ar = new ArrayList<>();
			mDTO = new MemberDTO();
			while(rs.next()) {
				BookDTO bookDTO = new BookDTO();
				
				bookDTO.setId(rs.getString("ID"));
				bookDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
				bookDTO.setOpenning_date(rs.getDate("OPENING_DATE"));
				bookDTO.setAccount_num(rs.getString("ACCOUNT_NUM"));
				
				ar.add(bookDTO);
				
			}
					
			mDTO.setAr(ar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return mDTO; //MemberDTO 객체 반환
		
	}
	
	
	public int setMember(MemberDTO memberDTO) { //회원가입 메서드
		
		Connection con = null;
		PreparedStatement st = null;		
		int result = 0;
		
		try {
			con = dbConnect.getConnect();
			String sql = "INSERT INTO MEMBER "
					+ "VALUES (?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			st.setString(3, memberDTO.getName());
			st.setString(4, memberDTO.getPhone());
			st.setString(5, memberDTO.getEmail());
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	
	public MemberDTO getLogin(MemberDTO memberDTO) { // 로그인 메서드
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		MemberDTO mDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * "
					+ " FROM MEMBER "
					+ " WHERE ID = ? and PW = ? ";
			st = con.prepareStatement(sql);

			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			
			rs = st.executeQuery();

			if(rs.next()) {
				mDTO = new MemberDTO();
				
				mDTO.setId(rs.getString("ID"));
				mDTO.setPw(rs.getString("PW"));
				mDTO.setName(rs.getString("NAME"));
				mDTO.setPhone(rs.getString("PHONE"));
				mDTO.setEmail(rs.getString("EMAIL"));		
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return mDTO;
	}
	
	
	public ArrayList<MemberDTO> memberAll() { // 전체회원 정보 메서드
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<MemberDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT ID, NAME, PHONE, EMAIL FROM MEMBER";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setId(rs.getString(1));
				memberDTO.setName(rs.getString(2));
				memberDTO.setPhone(rs.getString(3));
				memberDTO.setEmail(rs.getString(4));
				
				ar.add(memberDTO);

			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		return ar;
		
	}
	
}
