package com.shaymee.s1.trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shaymee.s1.book.BookDTO;
import com.shaymee.s1.member.MemberDTO;
import com.shaymee.s1.util.BankConnect;

public class TradeDAO {

	private BankConnect dbConnect;
	
	public TradeDAO() {
		dbConnect = new BankConnect();
	}

	
	public void tradePaid(TradeDTO tradeDTO) {//계좌이체 메소드
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con = dbConnect.getConnect();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public MemberDTO tradeInfo(MemberDTO memberDTO) {//거래내역 메소드
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BookDTO> ar = new ArrayList<>();
		MemberDTO mDTO = memberDTO;
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT B.PRODUCT_ID, T.ACCOUNT_NUM, T.TRADE_DATE, T.TRADE_AMOUNT, T.RECEIVED_PAID, T.BALANCE "
					+ " FROM TRADE T inner join BOOK B ON (B.ACCOUNT_NUM = T.ACCOUNT_NUM) inner join MEMBER M "
					+ " ON (M.ID = B.ID) "
					+ " WHERE M.ID = ? "
					+ " ORDER BY B.PRODUCT_ID ASC";
			st = con.prepareStatement(sql);
			st.setString(1, memberDTO.getId());
			
			rs = st.executeQuery();
			
			
			while(rs.next()) {
				BookDTO bookDTO = new BookDTO();
				TradeDTO tradeDTO = new TradeDTO();
				
				bookDTO.setProduct_id(rs.getInt(1));
				tradeDTO.setAccount_num(rs.getString(2));
				tradeDTO.setTrade_date(rs.getDate(3));
				tradeDTO.setTrade_amount(rs.getInt(4));
				tradeDTO.setReceived_paid(rs.getInt(5));
				tradeDTO.setBalance(rs.getDouble(6));
				bookDTO.setTradeDTO(tradeDTO);
				
				System.out.println(bookDTO.getAccount_num());
				ar.add(bookDTO);
				
				if(!rs.next()) {
					mDTO.setAr(ar);
				}
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
