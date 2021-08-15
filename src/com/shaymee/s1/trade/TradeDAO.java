package com.shaymee.s1.trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shaymee.s1.util.BankConnect;

public class TradeDAO {

	private BankConnect dbConnect;
	
	public TradeDAO() {
		dbConnect = new BankConnect();
	}
	
	
		
	public ArrayList<TradeDTO> balanceInfo() {//잔액조회 메소드
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<TradeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT T.ACCOUNT_NUM, T.BALANCE "
					+ " FROM TRADE T inner join BOOK B"
					+ " ON (T.ACCOUNT_NUM=B.ACCOUNT_NUM) inner join MEMBER M "
					+ " ON (B.ID=M.ID)"
					+ " WHERE M.ID = 't1'";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				TradeDTO tradeDTO = new TradeDTO();
				
				tradeDTO.setAccount_num(rs.getString("ACCOUNT_NUM"));
				tradeDTO.setBalance(rs.getDouble("BALANCE"));
				
				ar.add(tradeDTO);
				
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
	
	
	public void tradeInfo() {//거래내역 메소드
		
		
	}
	
	
	
}
