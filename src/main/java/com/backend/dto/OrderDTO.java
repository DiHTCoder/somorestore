package com.backend.dto;

import java.sql.Date;
import java.util.List;

public class OrderDTO {
	private Long id;
	private Date order_date;
	private Double discount;
	private Long total_price;
	private Boolean payment_status;
	private List<ProductDTO> product;

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Long getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Long total_price) {
		this.total_price = total_price;
	}

	public Boolean getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(Boolean payment_status) {
		this.payment_status = payment_status;
	}

	public List<ProductDTO> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
