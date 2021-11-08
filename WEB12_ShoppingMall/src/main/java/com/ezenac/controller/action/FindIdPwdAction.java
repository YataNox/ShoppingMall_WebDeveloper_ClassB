package com.ezenac.controller.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindIdPwdAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/findIdPw.jsp";
		
		// RequestDispatcher rd = request.getRequestDispatcher(url);
		// rd.forward(request, response);
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
