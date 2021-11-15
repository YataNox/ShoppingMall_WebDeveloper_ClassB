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
import com.ezenac.util.Paging;

public class AdminProductListAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		
		HttpSession session = request.getSession();
		AdminVO id = (AdminVO) session.getAttribute("loginAdmin");
		int page = 1;
		
		if(id == null) {
			url = "shop.do?command=admin";
		}else {
			if(request.getParameter("page") != null){
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page") != null) {
				page = (int)session.getAttribute("page");
			}else {
				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			AdminDao adao = AdminDao.getInstance();
			int count = adao.getAllCount("product");
			paging.setTotalCount(count);
			ArrayList<ProductVO> productList = adao.listProduct();
			
			request.setAttribute("productList", productList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
