package com.onlinestorewepr.controller.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.service.CartService;

@WebServlet(name = "CartUserServlet", value = {"/web/cart"})
public class CartUserServlet extends HttpServlet {
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        resp.setContentType("text/html;charset=UTF-8");
	        int pid = Integer.parseInt(req.getParameter("pid"));
	        String username = req.getParameter("username");
	        CartService cartService = new CartService(req,resp);
	        cartService.addProductToCart(pid, username);
	        req.getRequestDispatcher("/web/shop").forward(req,resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        super.doPost(req, resp);
	    }
}
