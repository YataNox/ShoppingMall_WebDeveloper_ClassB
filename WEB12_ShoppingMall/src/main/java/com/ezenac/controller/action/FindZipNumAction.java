package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindZipNumAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String dong = request.getParameter("dong");
		
		if(dong != null) {
			
		}else {
			// 아무것도 안하고 그냥 findZipNum.jsp로 이동
		}
		
		RequestDispatcher rs = request.getRequestDispatcher("member/findZipNum.jsp");
		rs.forward(request, response);
	}
}
