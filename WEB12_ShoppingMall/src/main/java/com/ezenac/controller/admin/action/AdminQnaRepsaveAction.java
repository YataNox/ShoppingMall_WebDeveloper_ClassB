package com.ezenac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.AdminDao;
import com.ezenac.dto.AdminVO;
import com.ezenac.dto.QnaVO;

public class AdminQnaRepsaveAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaDetail.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) {
			url = "shop.do?command=admin";
		}else {
			AdminDao adao = AdminDao.getInstance();
			QnaVO qvo = new QnaVO();
			qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
			qvo.setReply(request.getParameter("reply"));
			// 답글 저장 및 답글 상태 변경('1' -> '2')
			adao.updateQna(qvo);
			// 원래 보던 Qna 페이지로 이동
			url = url + "&qseq=" + request.getParameter("pseq");
		}
		response.sendRedirect(url);
	}
}
