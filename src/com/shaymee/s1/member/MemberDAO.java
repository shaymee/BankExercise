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
	
	public int setMember(MemberDTO memberDTO) { //회원가입 method
		
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
	
	
	public ArrayList<MemberDTO> getLogin(MemberDTO memberDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		MemberDTO mDTO = null;
		ArrayList<MemberDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT M.*, B.ACCOUNT_NUM"
					+ " FROM MEMBER M inner join BOOK B "
					+ " ON (M.ID=B.ID) "
					+ " WHERE M.ID = ? and M.PW = ? ";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			st.setString(2, memberDTO.getPw());
			
			rs = st.executeQuery();
			
			ArrayList<BookDTO> ar2 = new ArrayList<>();
			while(rs.next()) {
				mDTO = new MemberDTO();
				BookDTO bookDTO = new BookDTO();

				mDTO.setId(rs.getString("ID"));
				mDTO.setPw(rs.getString("PW"));
				mDTO.setName(rs.getString("NAME"));
				mDTO.setPhone(rs.getString("PHONE"));
				mDTO.setEmail(rs.getString("EMAIL"));		
				
				bookDTO.setAccount_num(rs.getString("ACCOUNT_NUM"));
				
				ar2.add(bookDTO);
				mDTO.setAr(ar2);
				ar.add(mDTO);
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
