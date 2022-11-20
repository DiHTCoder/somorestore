package com.onlinestorewepr.controller.web.Product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Product;

/**
 * Servlet implementation class viewProductDetails
 */
@WebServlet(value ={"/viewProductDetails"})
public class viewProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
//		String id = request.getParameter("productId");
//		int id_int = Integer.parseInt(id);
//		System.out.print(id_int);
//		System.out.print("ABC");
		ProductDAO product = new ProductDAO();
		Product productEnti = product.get(2);
//		System.out.print(productEnti.getName());
//		ProductImageDAO img = new ProductImageDAO();
//		ProductImage listImg =  img.getByIdProduct(Integer.parseInt(id));
//		request.setAttribute("imgs",listImg);
//		request.setAttribute("product", product.get(2));
		request.getRequestDispatcher("admin/orders.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
