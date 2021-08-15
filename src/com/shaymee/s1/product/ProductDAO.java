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
		
	
	public ArrayList<ProductDTO> kindOfproduct() {
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
				
				productDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
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
	
	public ProductDTO getProductOne(ProductDTO productDTO) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ProductDTO pDTO = productDTO;
		
		try {
			con = dbConnect.getConnect();
			String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_ID = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, productDTO.getProduct_id());
			rs = st.executeQuery();
			
			if(rs.next()) {				
				pDTO.setProduct_id(rs.getInt("PRODUCT_ID"));
				pDTO.setProduct_name(rs.getString("PRODUCT_NAME"));
				pDTO.setInterest(rs.getDouble("INTEREST"));
				pDTO.setOnsale(rs.getString("ONSALE"));
				
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
		
		return pDTO;
	}
	

	
}
