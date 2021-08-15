package com.shaymee.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shaymee.s1.util.BankConnect;

public class ProductDAO {

	private BankConnect dbConnect;
	
	public ProductDAO() {
		dbConnect = new BankConnect();
	}
		
	
	public ArrayList<ProductDTO> productInfo() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM PRODUCT";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				ProductDTO productDTO = new ProductDTO();
				
				productDTO.setProduct_id(rs.getString("PRODUCT_ID"));
				productDTO.setProduct_name(rs.getString("PRODUCT_NAME"));
				productDTO.setInterest(rs.getDouble("INTEREST"));
				productDTO.setOnsale(rs.getString("ONSALE"));
				
				ar.add(productDTO);
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
