package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CategoryDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductService{
    HttpServletResponse resp;
    HttpServletRequest req;
    private ProductDAO productDAO;
    private CategoryDAO categoryDAO;
    private ServiceResult serviceResult;

    public ProductService(HttpServletRequest request, HttpServletResponse response){
        this.req =request;
        this.resp =response;
        productDAO = new ProductDAO();
        categoryDAO = new CategoryDAO();
    }

    public void getALL(){
        List<Product> productList = productDAO.getAll();
        req.setAttribute("listAllProducts",productList);
    }

}
