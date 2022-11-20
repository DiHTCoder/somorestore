package com.onlinestorewepr.service;


import com.onlinestorewepr.dao.OrderDAO;
import com.onlinestorewepr.dao.OrderItemDAO;
import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.OrderItem;

import java.util.List;


public class OrderService {
	ServiceResult serviceResult = new ServiceResult();
	public ServiceResult getServiceResult() {
	    return serviceResult;
	  }

	  public void setServiceResult(ServiceResult serviceResult) {
	    this.serviceResult = serviceResult;
	  }
	  
	public void updateOrder(int id, String phone, String address, String status) {
		
		OrderDAO orderDAO = new OrderDAO();
		Order order = orderDAO.get(id);
	    String message = "", messageType = "";
	    if (order != null) {
	      try {
	    	  if(!phone.isEmpty())
	    		  order.setPhone(phone);
	    	  if(!address.isEmpty())
	    		  order.setAddress(address);
	    	  if(!status.isEmpty())
	    		  order.setStatus(status);
	    	  orderDAO.update(order);
	      } catch (Exception e) {
	        e.printStackTrace();
	      }

	    } else {
	      message = String.format("Category with name %s does not exist", id);
	      messageType = "danger";
	    }

	    serviceResult.setMessage(message);
	    serviceResult.setMessageType(messageType);
	  }


}
