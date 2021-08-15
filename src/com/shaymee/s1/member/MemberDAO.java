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
	
	
	public MemberDTO getLogin(MemberDTO memberDTO) {
		
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
	
	
}
