package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao ist = new OrderDao();
	public static OrderDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
}
