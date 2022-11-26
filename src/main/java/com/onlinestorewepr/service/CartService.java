package com.onlinestorewepr.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.CartDAO;
import com.onlinestorewepr.dao.CartItemDAO;
import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.OrderItemDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Cart;
import com.onlinestorewepr.entity.CartItem;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.OrderItem;
import com.onlinestorewepr.entity.Product;

public class CartService {
	HttpServletResponse resp;
	HttpServletRequest req;

	public CartService(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.resp = response;
	}

	public CartService() {

	}

	public void addProductToCart(int pid, String username) {
		Product product = new Product();
		ProductDAO productDAO = new ProductDAO();
		product = productDAO.get(pid);
		OrderDAO orderDAO = new OrderDAO();
		List<Order> order_list = new ArrayList<Order>();
		Order result = new Order();
		order_list = orderDAO.getAll();
		for (Order x : order_list) {
			if (x.getUser() != null) {
				if (x.getUser().getUsername().equals(username)) {
					result = orderDAO.get(x.getId());
				}
			}
		}
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		List <OrderItem> orderItem_list = new ArrayList<OrderItem>();
		orderItem_list = orderItemDAO.getAll();
		for (OrderItem x: orderItem_list) {
			if (x.getProduct().getId() == product.getId() && x.getOrder().getId() == result.getId()) {
				x.setQuantity(x.getQuantity()+1);
				orderItemDAO.update(x);
				return;
			}
		}
		OrderItem orderItem = new OrderItem();
		orderItem.setPrice(product.getPrice());
		orderItem.setQuantity(1);
		orderItem.setOrder(result);
		orderItem.setProduct(product);
		orderItemDAO.insert(orderItem);
	}

	public void deleteProductToCart(int pid, String username) {
		Product product = new Product();
		ProductDAO productDAO = new ProductDAO();
		product = productDAO.get(pid);
		List <OrderItem> product_list = product.getOrderItems();
		OrderDAO orderDAO = new OrderDAO();
		List<Order> order_list = new ArrayList<Order>();
		Order result = new Order();
		order_list = orderDAO.getAll();
		for (Order x : order_list) {
			if (x.getUser() != null)
			if (x.getUser().getUsername().equals(username)) {
				result = x;
			}
		}
		List <OrderItem> addnew = new ArrayList <OrderItem>();
		for (OrderItem x: product_list) {
			if (x.getOrder().getId() != result.getId())
				addnew.add(x);
		}
		product.setOrderItems(addnew);
		productDAO.update(product);
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		OrderItem orderItem = new OrderItem();
		List<OrderItem> orderItem_list = new ArrayList<OrderItem>();
		orderItem_list = orderItemDAO.getAll();
		List<OrderItem> ls = result.getOrderItems();
		List<OrderItem> rs = new ArrayList<OrderItem>();
		for (OrderItem x: ls) {
			if (x.getProduct().getId() != pid)
				rs.add(x);
		}
		result.setOrderItems(rs);
		orderDAO.update(result);
		for (OrderItem x : orderItem_list) {
			if (x.getProduct().getId() == pid && x.getOrder().getId() == result.getId()) {
				x.setOrder(null);
				x.setProduct(null);
				orderItemDAO.update(x);
				orderItemDAO.delete(x.getId());
				return;
			}
		}
	}

	public void updateProductToCart(int pid, String username, int quantity) {
		OrderItem orderItem = new OrderItem();
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		List<OrderItem> orderItem_list = new ArrayList<OrderItem>();
		orderItem_list = orderItemDAO.getAll();
		OrderDAO orderDAO = new OrderDAO();
		List<Order> order_list = new ArrayList<Order>();
		Order result = new Order();
		order_list = orderDAO.getAll();
		for (Order x : order_list) {
			if (x.getUser() != null)
			if (x.getUser().getUsername().equals(username)) {
				result = x;
			}
		}
		for (OrderItem x : orderItem_list) {
			if (x.getProduct().getId() == pid && x.getOrder().getId() == result.getId()) {
				x.setQuantity(quantity);
				orderItemDAO.update(x);
				return;
			}
		}
	}

	public List<Product> getAllProduct(String username) {
		OrderDAO orderDAO = new OrderDAO();
		List<Order> order_list = new ArrayList<Order>();
		Order result = new Order();
		order_list = orderDAO.getAll();
		for (Order x : order_list) {
			if (x.getUser() != null)
			if (x.getUser().getUsername().equals(username)) {
				result = x;
			}
		}
		List<Product> product_result = new ArrayList<Product>();
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		List<OrderItem> orderItem = new ArrayList<OrderItem>();
		orderItem = orderItemDAO.getAll();
		for (OrderItem x : orderItem) {
			if (x.getOrder().getId() == result.getId()) {
				Product addnew = x.getProduct();
				addnew.setQuantity(x.getQuantity());
				product_result.add(addnew);
			}
		}
		return product_result;
	}
	

}