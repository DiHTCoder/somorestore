package com.onlinestorewepr.controller.web.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

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
        req.setCharacterEncoding("UTF-8");
        Date date=java.util.Calendar.getInstance().getTime();
        String username = req.getParameter("username");
        int total = Integer.parseInt(req.getParameter("total"));
        String name = req.getParameter("customer-name");
        String address = req.getParameter("customer-address");
        String phone = req.getParameter("customer-phone");
        String note = req.getParameter("customer-note");
        OrderDAO orderDAO = new OrderDAO();
        List <Order> order_list = new ArrayList<Order>();
        order_list = orderDAO.getAll();
        Order result = new Order();
        for (Order x: order_list) {
            if (x.getUser().getUsername().equals(username)) {
                result = orderDAO.get(x.getId());
            }
        }
        UserDAO userDAO = new UserDAO();
        result.setCreated(date);
        result.setUser(userDAO.get(username));
        result.setAddress(address);
        result.setName(name);
        result.setPhone(phone);
        result.setNote(note);
        result.setTotal(total);
        orderDAO.insert(result);

        req.getRequestDispatcher("/web/profile.jsp").forward(req,resp);
    }
}
