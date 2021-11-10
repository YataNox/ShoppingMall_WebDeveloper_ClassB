package com.ezenac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezenac.dto.CartVO;
import com.ezenac.util.DBman;

public class OrderDao {
	private OrderDao() {}
	private static OrderDao ist = new OrderDao();
	public static OrderDao getInstance() {return ist;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int insertOrder(ArrayList<CartVO> list, String id) {
		int oseq = 0; // orders 테이블에 추가된 주문번호를 리턴할 예정입니다.
		con = DBman.getConnection();
		// 1. 주문 번호(시퀀스 자동입력)과 구매자 아이디로 orders 테이블에 레코드 추가
		String sql = "insert into orders(oseq, id) values(orders_seq.nextVal, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			// 2. Orders 테이블에 시퀀스로 입력된 가장 마지막(방금 추가한) 주문 번호 조회
			pstmt.close();
			sql = "select max(oseq) as max_oseq from orders";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				oseq = rs.getInt("max_oseq");
			
			// 3. list의 주문들을 Orders에서 얻은 마지막 주문 번호와 함께 order_detail에 추가
			pstmt.close();
			// 반복 실행문을 이용해 list의 갯수만큼 반복
			for(CartVO cvo : list) {
				sql = "insert into order_detail(odseq, oseq, pseq, quantity) "
						+ "values(order_detail_seq.nextVal, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, oseq);
				pstmt.setInt(2, cvo.getPseq());
				pstmt.setInt(3,cvo.getQuantity());
				pstmt.executeUpdate();
				
				// 4. order_detail에 추가된 카트 내용은 cart 테이블에서 처리되었으므로 삭제 또는 result를 2로 변경
				pstmt.close();
				// sql = "delete from cart where cseq = ?";
				sql = "update cart set result='2' where cseq = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, cvo.getCseq());
				pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBman.close(con, pstmt, rs);
		}
		
		return oseq;
	}
}
