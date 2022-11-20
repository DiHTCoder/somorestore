package com.onlinestorewepr.controller.web.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
//        Cookie cookie =null;
//        Cookie[] cookies =null;
//        cookies = req.getCookies();
//        for (int i = 0; i < cookies.length; i++) {
//            cookie = cookies[i];
//            out.print("Name : " + cookie.getName() + ", ");
//            out.print("Value: " + cookie.getValue() + " <br/>");
//        }
//        out.println(userLogged);
    }
}
