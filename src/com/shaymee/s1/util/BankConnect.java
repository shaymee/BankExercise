package com.shaymee.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class BankConnect {

	public Connection getConnect() throws Exception {
		
		String user = "user02";
		String password = "user02";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;

	}
	
	
}
