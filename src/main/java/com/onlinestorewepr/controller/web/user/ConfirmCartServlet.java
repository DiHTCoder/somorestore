package com.onlinestorewepr.controller.web.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.service.CartService;

@WebServlet(name = "ConfirmCartServlet", value = { "/web/confirmcart" })
public class ConfirmCartServlet extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String name = req.getParameter("cname");
        String address = req.getParameter("caddress");
        String phone = req.getParameter("cphone");
        String email = req.getParameter("cemail");
        String note = req.getParameter("cnote");
        OrderDAO orderDAO = new OrderDAO();
        List <Order> order_list = new ArrayList<Order>();
        order_list = orderDAO.getAll();
        Order result = new Order();
        for (Order x: order_list) {
        	if (x.getUser().getUsername().equals(username)) {
        		result = orderDAO.get(x.getId());
        	}
        }
        result.setAddress(address);
        result.setName(name);
        result.setPhone(phone);
        result.setNote(note);
        orderDAO.update(result);
        Order neworder = new Order();
        UserDAO userDAO = new UserDAO();
        neworder.setUser(userDAO.get(username));
        orderDAO.insert(neworder);
        //req.getRequestDispatcher("/web/profile.jsp").forward(req,resp);
    }
}
