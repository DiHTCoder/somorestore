package com.onlinestorewepr.controller.admin.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.service.OrderService;

/**
 * Servlet implementation class order_details
 */
@WebServlet("/admin/updateOrder")
public class update_orderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_orderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("orderId")) ;
		OrderDAO dao = new OrderDAO();
		Order order = dao.get(id);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/admin/update-order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("orderId"));
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		System.out.print(id);
		System.out.print(phone);
		
		OrderService orderService = new OrderService();
	    orderService.updateOrder(id, phone, address, status);
	    
	    request.getRequestDispatcher("/admin/orders").forward(request,response);
		
	}

}
