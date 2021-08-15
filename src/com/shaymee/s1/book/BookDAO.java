package com.shaymee.s1.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shaymee.s1.member.MemberDTO;
import com.shaymee.s1.trade.TradeDTO;
import com.shaymee.s1.util.BankConnect;

public class BookDAO {

	private BankConnect dbConnect;
	
	public BookDAO() {
		dbConnect = new BankConnect();
	}
	
	public ArrayList<BookDTO> myBookInfo(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BookDTO> ar = null;
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT B.PRODUCT_ID, B.OPENING_DATE, T.BALANCE, B.ACCOUNT_NUM, B.ID "
					+ " FROM BOOK B inner join TRADE T "
					+ " ON (B.ACCOUNT_NUM = T.ACCOUNT_NUM) inner JOIN MEMBER M "
					+ " ON (B.ID = M.ID)"
					+ " WHERE M.PW = ?";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getPw());
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				BookDTO bookDTO = new BookDTO();
				TradeDTO tradeDTO = new TradeDTO();
				
				bookDTO.setProduct_id(rs.getString("PRODUCT_ID"));
				bookDTO.setOpenning_date(rs.getDate("OPENING_DATE"));
				bookDTO.getTradeDTO().setBalance(rs.getDouble("BALANCE"));
				bookDTO.setAccount_num(rs.getString("ACCOUNT_NUM"));
				bookDTO.setId(rs.getString("ID"));
				
				ar.add(bookDTO);
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
