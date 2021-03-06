package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.AdminVO;
import com.ezenac.dto.OrderVO;
import com.ezenac.dto.ProductVO;
import com.ezenac.dto.QnaVO;
import com.ezenac.util.DBman;
import com.ezenac.util.Paging;

public class AdminDao {
	private AdminDao() {}
	private static AdminDao ist = new AdminDao();
	public static AdminDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public AdminVO workerCheck(String workId) {
		AdminVO avo = null;
		String sql = "select * from worker where id=?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, workId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avo = new AdminVO();
				avo.setId(rs.getString("id"));
				avo.setPwd(rs.getString("pwd"));
				avo.setName(rs.getString("name"));
				avo.setPhone(rs.getString("phone"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return avo;
	}

	public ArrayList<ProductVO> listProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		//String sql ="select * from product order by pseq desc";
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, p.* from "
				+ "((select * from product where name like '%'||?||'%' order by pseq desc) p)"
				+ ") where rn >=?"
				+ ") where rn <=?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pvo = new ProductVO();
				pvo.setPseq(rs.getInt("pseq"));
				pvo.setIndate(rs.getTimestamp("indate"));
				pvo.setName(rs.getString("name"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				list.add(pvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public void insertProduct(ProductVO pvo) {
String sql ="insert into product(pseq, kind, name, price1, price2, price3, "
		+ "content, image) values(product_seq.nextVal, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice1());
			pstmt.setInt(4, pvo.getPrice2());
			pstmt.setInt(5, pvo.getPrice3());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getImage());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public void updateProduct(ProductVO pvo) {
		String sql = "update product set kind=?, name=?, price1=?, "
				+ "price2=?, price3=?, content=?, image=?, bestyn=?, useyn=? where pseq=?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pvo.getKind());
			pstmt.setString(2, pvo.getName());
			pstmt.setInt(3, pvo.getPrice1());
			pstmt.setInt(4, pvo.getPrice2());
			pstmt.setInt(5, pvo.getPrice3());
			pstmt.setString(6, pvo.getContent());
			pstmt.setString(7, pvo.getImage());
			pstmt.setString(8, pvo.getBestyn());
			pstmt.setString(9, pvo.getUseyn());
			pstmt.setInt(10, pvo.getPseq());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}

	public int getAllCount(String tableName, String fieldName, String key) {
		int count = 0;
		String sql = "select count(*) as cnt from " + tableName + " where "
				+ fieldName + " like '%'||?||'%'";
		// ????????? like '%?%'?????? ???? ??????????????? ?????????, ?????? ????????? ????????? ???????????? ?????? ?????? ???????????????.
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return count;
	}

	public ArrayList<OrderVO> listOrder(Paging paging, String key) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, o.* from "
				+ "((select * from order_view where mname like '%'||?||'%' order by result, odseq desc) o)"
				+ ") where rn >= ?"
				+ ") where rn <= ?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderVO ovo = new OrderVO();
				ovo.setOdseq(rs.getInt("odseq"));
				ovo.setOseq(rs.getInt("Oseq"));
				ovo.setId(rs.getString("id"));
				ovo.setIndate(rs.getTimestamp("indate"));
				ovo.setPseq(rs.getInt("pseq"));
				ovo.setQuantity(rs.getInt("quantity"));
				ovo.setResult(rs.getString("result"));
				ovo.setMname(rs.getString("mname"));
				ovo.setZip_num(rs.getString("zip_num"));
				ovo.setAddress(rs.getString("address"));
				ovo.setPhone(rs.getString("phone"));
				ovo.setPname(rs.getString("pname"));
				ovo.setPrice2(rs.getInt("price2"));
				
				list.add(ovo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public void updateOrderResult(String odseq) {
		String sql = "update order_detail set result = '2' where odseq = ?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(odseq));
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
	}

	public ArrayList<QnaVO> listQna(Paging paging, String key) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "select * from ("
				+ "select * from ("
				+ "select rownum as rn, q.* from "
				+ "((select * from qna where subject like '%'||?||'%' or content like '%'||?||'%' order by qseq desc) q)"
				+ ") where rn >= ?"
				+ ") where rn <= ?";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			pstmt.setInt(3, paging.getStartNum());
			pstmt.setInt(4, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QnaVO qvo = new QnaVO();
				qvo.setQseq(rs.getInt("qseq"));
				qvo.setSubject(rs.getString("subject"));
				qvo.setContent(rs.getString("content"));
				qvo.setReply(rs.getString("reply"));
				qvo.setId(rs.getString("id"));
				qvo.setRep(rs.getString("rep"));
				qvo.setIndate(rs.getTimestamp("indate"));
				
				list.add(qvo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return list;
	}

	public int getAllCount(String key) {
		int count = 0;
		String sql = "select count(*) as cnt from qna "
				+ "where subject like '%'||?||'%' or content like '%'||?||'%'";
		
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, key);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("cnt");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return count;
	}

	public void updateQna(QnaVO qvo) {
		String sql = "update qna set reply=?, rep='2' where qseq=?";
		try {
			con = DBman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qvo.getReply());
			pstmt.setInt(2, qvo.getQseq());
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
	}
}
