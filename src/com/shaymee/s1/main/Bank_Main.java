package com.shaymee.s1.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import com.shaymee.s1.util.BankConnect;


public class Bank_Main {

	public static void main(String[] args) {
		
		BankController controller = new BankController();
		
		controller.start();
	
		
		
		
		
		
		
		
		
		
//		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.getTimeInMillis()&100000);
		
		
		
//		BankConnect dbConnect = new BankConnect();
//		
//		Connection con = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		
//		try {
//			con = dbConnect.getConnect();
//			String sql = "select * from member";
//			st = con.prepareStatement(sql);
//			rs = st.executeQuery();
//			
//			while(rs.next()) {
//				
//				System.out.println(rs.getString("ID"));
//				System.out.println(rs.getString("NAME"));
//				System.out.println("=================");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		

	}

}
