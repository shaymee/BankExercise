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

	
	public int tradePaid(ArrayList<TradeDTO> ar, int paid) {//계좌이체 메소드
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		try {
			con = dbConnect.getConnect();
			String sql = "INSERT INTO TRADE (ACCOUNT_NUM, TRADE_DATE, TRADE_AMOUNT, RECEIVED_PAID, BALANCE) "
					+ " VALUES (?, sysdate, ?, ?, ?)";
			
			System.out.println(ar.get(ar.size()-1).getBalance());
			System.out.println(ar.get(ar.size()-1).getAccount_num());
			
			st = con.prepareStatement(sql);
			st.setString(1, ar.get(ar.size()-1).getAccount_num());

			st.setDouble(2, -(paid));
			st.setDouble(3, paid);
			st.setDouble(4, (ar.get(ar.size()-1).getBalance())+paid);
			
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
	
	
	public MemberDTO tradeInfo(MemberDTO memberDTO) { //거래내역 메소드
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
				TradeDTO tDTO = new TradeDTO();
				
				bookDTO.setProduct_id(rs.getInt(1));
				tDTO.setAccount_num(rs.getString(2));
				tDTO.setTrade_date(rs.getDate(3));
				tDTO.setTrade_amount(rs.getInt(4));
				tDTO.setReceived_paid(rs.getInt(5));
				tDTO.setBalance(rs.getDouble(6));
				bookDTO.setTradeDTO(tDTO);
				
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
	
	public ArrayList<TradeDTO> accountReport(TradeDTO tradeDTO) { //계좌별로 거래내역 모음 메소드
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<TradeDTO> ar = new ArrayList<>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT ACCOUNT_NUM, BALANCE FROM TRADE WHERE ACCOUNT_NUM = ?";
			st = con.prepareStatement(sql);
			st.setString(1, tradeDTO.getAccount_num());
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				TradeDTO tDTO = new TradeDTO();
				
				tDTO.setAccount_num(rs.getString("ACCOUNT_NUM"));
				tDTO.setBalance(rs.getDouble("BALANCE"));
				
				ar.add(tDTO);
				
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
