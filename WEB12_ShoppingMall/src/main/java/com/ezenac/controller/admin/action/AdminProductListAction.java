package com.ezenac.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.AdminDao;
import com.ezenac.dto.AdminVO;
import com.ezenac.dto.ProductVO;

public class AdminProductListAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		
		HttpSession session = request.getSession();
		AdminVO id = (AdminVO) session.getAttribute("loginAdmin");
		
		if(id == null) {
			url = "shop.do?command=admin";
		}else {
			AdminDao adao = AdminDao.getInstance();
			ArrayList<ProductVO> productList = adao.listProduct();
			request.setAttribute("productList", productList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
