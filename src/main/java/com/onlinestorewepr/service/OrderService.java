package com.onlinestorewepr.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.OrderItemDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.OrderItem;

public class OrderService {
	private OrderDAO orderDAO;

	private OrderItemDAO orderItemDAO;

	HttpServletRequest req;

	HttpServletResponse resp;

	public OrderService() {
		orderDAO = new OrderDAO();
		orderItemDAO = new OrderItemDAO();
	}

	public OrderService(HttpServletRequest req, HttpServletResponse resp) {
		orderDAO = new OrderDAO();
		orderItemDAO = new OrderItemDAO();
		this.req = req;
		this.resp = resp;
	}

	public void showOrderDetail() throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("/admin/orders.jsp").forward(req, resp);
	}

	public void showEditOrderDetail() throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("/admin/update-order.jsp").forward(req, resp);
	}

	public Order getOrder(int id) {
		return orderDAO.get(id);
	}
	
	public List<Order> getAllOrder(){
		return orderDAO.getAll();
	}

	public List<OrderItem> getAllOrderItem() {
		return orderItemDAO.getAll();
	}

	public void editOrder(Order order) {
		String phone = req.getParameter("phone").trim();
		String address = req.getParameter("address").trim();
		String status = req.getParameter("status").trim();

		order.setPhone(phone);
		order.setAddress(address);
		order.setStatus(status);
	}

	public void updateOrder() throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int order_id = Integer.parseInt(req.getParameter("order_id"));
		Order order = getOrder(order_id);
		editOrder(order);
		orderDAO.update(order);
		showOrderDetail();
	}

}
