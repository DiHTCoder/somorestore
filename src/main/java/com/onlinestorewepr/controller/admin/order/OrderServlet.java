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
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.OrderItem;
import com.onlinestorewepr.entity.User;
import com.onlinestorewepr.service.OrderService;

@WebServlet("/admin/orders")
public class OrderServlet extends HttpServlet {
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
		OrderDAO dao = new OrderDAO();
		List<Order> orders = dao.getAll();
		OrderItemDAO ItemDAO = new OrderItemDAO();
		ProductDAO productDAO = new ProductDAO();
		UserDAO userDAO = new UserDAO();
		List<OrderItem> orderItem_list = ItemDAO.getAll();
		List<User> user = userDAO.getAll();
		for (User x: user)
		{
			Order z = new Order();
			for (Order y: orders)
			{
				if (y.getUser() != null)
				if (y.getUser().getName().equals(x.getName()))
				{
					z = y;
				}
			}
			boolean check = false;
			for (OrderItem y : orderItem_list)
			{
				if (y.getOrder().getId() == z.getId())
				{
					check = true;
				}
			}
			if (!check) orders.remove(z);
		}
		request.setAttribute("orders", orders);
		request.setAttribute("ItemDAO", ItemDAO);
		request.setAttribute("productDAO", productDAO);
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
