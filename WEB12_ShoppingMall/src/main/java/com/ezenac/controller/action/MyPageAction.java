package com.ezenac.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.OrderDao;
import com.ezenac.dto.MemberVO;
import com.ezenac.dto.OrderVO;

public class MyPageAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/mypage.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		if(mvo == null){
			url = "shop.do?command=login_form";
		}else {
			// 진행중인 주문 내역 :
			// mypage.jsp에 나타나는 목록은 orderList.jsp처럼 주문 상품 하나하나를
			// 표시하는게 아니라, orders 테이블에 있는 레코드 단위로 표시될 예정이며,
			// 한 번의 주문 안에 있는 상품들을 한 라인에 표시합니다(ex - 스니커즈 포함 1건, 부츠 포함 2건...)
			
			// 주문한 상품들의 상세 내용은 주문명을 클릭하면 나오는 orderDetail에서 표시하고
			// 현재는 표시하지 않을 예정입니다.
			// 주문을 대표하는 (상품명 : xxxx 포함 2건) 주문의 리스트가 만들어질 예정입니다.
			
			OrderDao odao = OrderDao.getInstance();
			// 화면에 표시될 리스트 생성(OrderVO.name : "XXXX 외 2건")
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
			
			// 현재 로그인 유저의 아이디 주인의 진행중인 주문의 주문 번호 리스트(oseq들의 리스트) 생성
			// scott이 주문한 주문 번호 : 6
			ArrayList<Integer> oseqList = odao.selectSeqOrderIng(mvo.getId());
			// order_view를 통해서 현재 진행중인 주문(처리전)의 주문 번호(oseq)들을 리스트로
			// 리턴받음. 중복된 값이 없어(distinct사용) 조회할 예정이며, 현재 아이디로 검색되고, 아직 주문 처리가
			// 되지 않은(result : 1) 주문 번호들(oseq들)이 ArrayList 형태로 리턴됩니다.
			
			/* for(Integer i : oseqList) { System.out.println(i); }*/
			for(Integer oseq : oseqList) {
				// 현재 oseq 값과 로그인 아이디를 이용해서 주문 리스크를 검색(대상 : order_view)
				// (주문 번호 한 건의 주문 상세 내역들(order_view의 상품들))
				// oseq 하나로 검색한 주문상세내역(주문상품들)의 리스트
				ArrayList<OrderVO> orderListIng = odao.listOrderById(mvo.getId(), oseq);
				// orderListIng을 이용해서 orderList에 들어갈 대표 상품명과 총 금액을 계산 및 결정합니다.
				for(OrderVO s : orderListIng) {
					System.out.println(s.getPname());
				}
				
				// orderListIng 리스트 중 첫 번째를 따로 보관(주문 대표 상품 이름 사용을 위해)
				OrderVO ovo = orderListIng.get(0);
				
				// 따로 보관한 첫 번째 주문의 상품명을 "ovo 상품명 포함 x건"으로 수정
				ovo.setPname(ovo.getPname() + " 포함 " + orderListIng.size() + " 건");
				//	ovo.setPname(ovo.getPname() + " 외 " + (orderListIng.size()-1) + " 건");
				
				// orderListIng내의 주문상품들의 가격을 이용하여 총 결제 금액을 게산하고
				int totalPrice = 0;
				for(OrderVO ovo1 : orderListIng)
					totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
				
				// 위의 대표상품 ovo의 금액으로 저장
				ovo.setPrice2(totalPrice);
				// 맨 처음 만들어놓은 orderList에 ovo를 추가합니다.
				orderList.add(ovo);
				
				System.out.println(ovo.getPname() + " " + ovo.getPrice2());
				System.out.println();
			}
			
			request.setAttribute("title", "진행 중인 주문 내역");
			request.setAttribute("orderList", orderList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
