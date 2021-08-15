package com.shaymee.s1.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.shaymee.s1.member.MemberDTO;
import com.shaymee.s1.product.ProductDTO;
import com.shaymee.s1.trade.TradeDTO;
import com.shaymee.s1.util.BankConnect;

public class BookDAO {

	private BankConnect dbConnect;
	
	public BookDAO() {
		dbConnect = new BankConnect();
	}
	
	public MemberDTO myBookInfo(MemberDTO memberDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BookDTO> ar = new ArrayList<>();
		MemberDTO mDTO = new MemberDTO();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT M.ID, B.PRODUCT_ID, B.OPENING_DATE, B.ACCOUNT_NUM, T.BALANCE "
					+ " FROM BOOK B inner join TRADE T "
					+ " ON (B.ACCOUNT_NUM = T.ACCOUNT_NUM) inner JOIN MEMBER M "
					+ " ON (B.ID = M.ID)"
					+ " WHERE M.PW = ?";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getPw());
			
			rs = st.executeQuery();
			
			mDTO = memberDTO;
			while(rs.next()) {
				BookDTO bookDTO = new BookDTO();
				TradeDTO tradeDTO = new TradeDTO();			
				
				bookDTO.setId(rs.getString(1));
				bookDTO.setProduct_id(rs.getInt(2));
				bookDTO.setOpenning_date(rs.getDate(3));
				bookDTO.setAccount_num(rs.getString(4));				
				tradeDTO.setBalance(rs.getDouble(5));
				bookDTO.setTradeDTO(tradeDTO);
				
				ar.add(bookDTO);
				mDTO.setAr(ar);
				
				
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
	
	
	public int makeBook(ProductDTO productDTO) {
		Connection con = null;
		PreparedStatement st = null;
		Calendar cal = Calendar.getInstance();
		int result = 0;
		
		try {
			con = dbConnect.getConnect();
			String sql = "INSERT INTO BOOK "
					+ " VALUES (?, sysdate, 0, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, productDTO.getProduct_id());
			st.setString(2, "1234-5678-"+(cal.getTimeInMillis()&100000));
			st.setString(3, productDTO.getMemberDTO().getId());
			
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
	
}
