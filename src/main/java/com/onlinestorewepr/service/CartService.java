package com.onlinestorewepr.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.CartDAO;
import com.onlinestorewepr.dao.CartItemDAO;
import com.onlinestorewepr.dao.CategoryDAO;
import com.onlinestorewepr.dao.ProductDAO;

public class CartService {
	HttpServletResponse resp;
    HttpServletRequest req;
    private CartDAO cart;
    private CartItemDAO cartItem;
    private ProductDAO product;
    
    public CartService(HttpServletRequest request, HttpServletResponse response){
        this.req =request;
        this.resp =response;
        cart = new CartDAO();
        cartItem = new CartItemDAO();
        product = new ProductDAO();
    }
    
    public void addProductToCart() throws IOException,ServletException{
    	
    }
}
