package com.onlinestorewepr.controller.admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.OrderItemDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.OrderItem;
import com.onlinestorewepr.service.OrderService;

/**
 * Servlet implementation class order
 */
@WebServlet("/admin/orders")
public class orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderController() {
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
		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
