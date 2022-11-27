package com.onlinestorewepr.controller.admin.account;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.User;
import com.onlinestorewepr.service.UserService;

@WebServlet({"/admin/accounts","/accounts"})
public class AccountServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		UserDAO userDAO = new UserDAO();
	    List<User> users = userDAO.getAll();
	    req.setAttribute("users", users);
	    req.getRequestDispatcher("/admin/accounts.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

}
