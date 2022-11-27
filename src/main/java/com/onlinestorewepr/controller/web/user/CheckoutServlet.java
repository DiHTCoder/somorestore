package com.onlinestorewepr.controller.web.user;

import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

@WebServlet("/web/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        CartService cartService = new CartService();
        req.setAttribute("cartlist", cartService.getAllProduct(username));
        int total = 0;
        for (Product x : cartService.getAllProduct(username)) {
            total += x.getQuantity() * x.getPrice();
        }
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
//        String transform = en.format(total);
        req.setAttribute("total", total);
        req.setAttribute("cartlist", cartService.getAllProduct(username));
        req.setAttribute("cartService", cartService);
        req.getRequestDispatcher("/web/checkout.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
