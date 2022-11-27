package com.onlinestorewepr.controller.shipper.authentication;

import com.onlinestorewepr.service.AdminService;
import com.onlinestorewepr.service.ShipperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShipperLoginServlet",value = {"/login-shipper","/shipper/login-shipper"})
public class ShipperLoginServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/shipper/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ShipperService shipperService = new ShipperService(req,resp);
        shipperService.shipperLogin();
    }
}
