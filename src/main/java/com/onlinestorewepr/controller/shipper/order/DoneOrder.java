package com.onlinestorewepr.controller.shipper.order;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.OrderItemDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DoneOrder",value = {"/shipper/done-order","/done-order"})
public class DoneOrder extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        OrderDAO dao = new OrderDAO();
        List<Order> orders = dao.getDoneOrders();
        OrderItemDAO ItemDAO = new OrderItemDAO();
        ProductDAO productDAO = new ProductDAO();
        //orders.remove(orders.size()-1);

        req.setAttribute("orders", orders);
        req.setAttribute("ItemDAO", ItemDAO);
        req.setAttribute("productDAO", productDAO);
        req.getRequestDispatcher("/shipper/done_order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
