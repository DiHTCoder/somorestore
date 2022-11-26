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

@WebServlet(name = "UpdateCartUserServlet", value = { "/web/updateCart" })
public class UpdateCartUserServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		int pid = Integer.parseInt(req.getParameter("pid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		String type = req.getParameter("type");
		String username = req.getParameter("username");
		CartService cartService = new CartService(req, resp);
		if (type.equals("inc"))
		{
			cartService.updateProductToCart(pid, username, quantity+1);
		}
		else
		{
			cartService.updateProductToCart(pid, username, quantity-1);
		}
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
		
	}
	
}
