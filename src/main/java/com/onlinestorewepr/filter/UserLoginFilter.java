//package com.onlinestorewepr.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter("/web/*")
//public class UserLoginFilter extends HttpFilter implements Filter {
//    private static final String[] loginRequireURLs = {"/profile","/update-profile"};
//
//
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response =(HttpServletResponse) resp;
//        HttpSession session = req.getSession();
//        Object ob = session.getAttribute("userLogged");
//
//        if(ob != null){
//            chain.doFilter(req,resp);
//        }
//        else {
//            response.sendRedirect(request.getContextPath()+"/web/login");
//        }
//
//    }
//    private boolean isLoginRequired(String requestURL) {
//        for (String loginRequiredURL : loginRequireURLs) {
//            if (requestURL.contains(loginRequiredURL)) {
//                return true;
//            }
//        }
//        return false;
//    }
//    @Override
//    public void init() throws ServletException {
//        super.init();
//    }
//
//
//    @Override
//    public void destroy() {
//
//    }
//}
