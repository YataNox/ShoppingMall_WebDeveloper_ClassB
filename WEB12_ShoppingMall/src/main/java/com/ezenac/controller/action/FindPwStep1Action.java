package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class FindPwStep1Action implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao mdao = MemberDao.getInstance();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberVO mvo = mdao.confirmIdnamePhone(id, name, phone);
		String url;
		
		if(mvo == null) {
			request.setAttribute("msg", "Id와 이름과 전화번호가 일치하는 회원이 없습니다.");
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			url = "member/findPwForm.jsp";
		}else {
			// 인증번호 전송
			url = "member/findPwconfirmNumber.jsp"; // 인증번호 입력 화면으로 이동
		}
		
		request.setAttribute("member", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
