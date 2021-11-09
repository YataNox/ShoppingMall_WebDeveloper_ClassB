package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ezenac.dto.CartVO;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao ist = new OrderDao();
	public static OrderDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertOrder(ArrayList<CartVO> list, String id) {
		int result = 0;
		
		return result;
	}
}
