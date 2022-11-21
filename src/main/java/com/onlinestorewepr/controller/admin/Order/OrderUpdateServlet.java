package com.onlinestorewepr.controller.admin.Order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.service.CategoryService;
import com.onlinestorewepr.service.OrderService;

@WebServlet({"/admin/updateOrder","/updateOrder"})
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderUpdateServlet() {
		super();
	}

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		int order_id = Integer.parseInt(request.getParameter("order_id"));
//	    if (order_id != 0) {
//	      OrderService orderService = new OrderService();
//	      Order order = orderService.getOrder(order_id);
//	      request.setAttribute("order", order);
////	      response.setAttribute("action", "edit");
//	    }
//	    request.getRequestDispatcher("/admin/update-order.jsp").forward(request, response);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		OrderService orderService = new OrderService(request, response);
//		orderService.updateOrder();
//	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		int id = Integer.parseInt(request.getParameter("orderId"));
		OrderDAO dao = new OrderDAO();
		Order order = dao.get(id);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/admin/update-order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("orderId"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		System.out.print(id);
		System.out.print(phone);

		OrderService orderService = new OrderService();
		orderService.updateOrder(id, phone, address, status);

		request.getRequestDispatcher("/admin/orders").forward(request, response);

	}
}
