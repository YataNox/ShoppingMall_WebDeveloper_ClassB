package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ezenac.dto.CartVO;
import com.ezenac.util.DBman;

public class CartDao {
	private CartDao() {}
	private static CartDao ist = new CartDao();
	public static CartDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void insertCart(CartVO cvo) {
		String sql = "insert into cart(cseq, id, pseq, quantity) values(cart_seq.nextVal, ?, ?, ?)";
		con = DBman.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cvo.getId());
			pstmt.setInt(2, cvo.getPseq());
			pstmt.setInt(3, cvo.getQuantity());
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}
}
