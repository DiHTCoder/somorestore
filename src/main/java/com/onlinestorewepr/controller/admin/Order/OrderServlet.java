package com.onlinestorewepr.controller.admin.Order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.service.OrderService;

@WebServlet("/admin/orders")
public class OrderServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public OrderServlet() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		OrderService orderService = new OrderService();
//		List<Order> orders = orderService.getAllOrder();
//
//		request.setAttribute("orders", orders);
//		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		super.doPost(request, response);
//	}
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		OrderDAO dao = new OrderDAO();
		List<Order> orders = dao.getAll();
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
