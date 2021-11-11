package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDao {
	private AdminDao() {}
	private static AdminDao ist = new AdminDao();
	public static AdminDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
}
