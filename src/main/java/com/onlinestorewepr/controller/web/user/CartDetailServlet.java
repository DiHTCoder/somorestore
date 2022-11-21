package com.onlinestorewepr.controller.web.user;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.service.CartService;

@WebServlet(name = "CartDetailServlet", value = { "/web/cartdetail" })
public class CartDetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String username = req.getParameter("username");
		String type = req.getParameter("type");
		if (type.equals("delete")) {
			doPost(req, resp);
			return;
		}
		CartService cartService = new CartService(req, resp);
		req.setAttribute("cartlist", cartService.getAllProduct(username));
		int total = 0;
		for (Product x : cartService.getAllProduct(username)) {
			total += x.getQuantity() * x.getPrice();
		}
		Locale localeEN = new Locale("en", "EN");
		NumberFormat en = NumberFormat.getInstance(localeEN);
		String transform = en.format(total);
		req.setAttribute("total", transform);
		req.getRequestDispatcher("/web/shopping-cart.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		if (type.equals("delete")) {
			int pid = Integer.parseInt(req.getParameter("pid"));
			String username = req.getParameter("username");
			CartService cartService = new CartService();
			cartService.deleteProductToCart(pid, username);
			CartService cartService1 = new CartService();
			req.setAttribute("cartlist", cartService1.getAllProduct(username));
			req.getRequestDispatcher("/web/shopping-cart.jsp").forward(req, resp);
		}
	}
}
