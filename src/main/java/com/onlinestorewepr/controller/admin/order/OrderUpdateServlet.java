package com.onlinestorewepr.controller.admin.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.service.CategoryService;
import com.onlinestorewepr.service.OrderService;

@WebServlet("/admin/update-order")
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderUpdateServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int order_id = Integer.parseInt(request.getParameter("order_id"));
	    if (order_id != 0) {
	      OrderService orderService = new OrderService();
	      Order order = orderService.getOrder(order_id);
	      request.setAttribute("order", order);
//	      response.setAttribute("action", "edit");
	    }
	    request.getRequestDispatcher("/admin/update-order.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		OrderService orderService = new OrderService(request, response);
		orderService.updateOrder();
	}

}
