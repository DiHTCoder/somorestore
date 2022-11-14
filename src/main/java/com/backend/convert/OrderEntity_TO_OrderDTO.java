package com.backend.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;
import com.backend.entity.OrderEntity;
import com.backend.entity.ProductOrderEntity;
import com.backend.repository.CustomerRepository;
import com.backend.repository.OrderRepository;
import com.backend.repository.ProductRepository;

@Component
public class OrderEntity_TO_OrderDTO {
	@Autowired
	private CustomerRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserEntity_TO_UserDTO userEntity_TO_userDTO;
	@Autowired
	private ProductEntity_TO_ProductDTO productEntity_TO_ProductDTO;

	public OrderDTO toDTO(OrderEntity orderEntity) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(orderEntity.getId());
		orderDTO.setOrder_date(orderEntity.getOrder_date());
		orderDTO.setDiscount(orderEntity.getDiscount());
		orderDTO.setTotal_price(orderEntity.getTotal_price());
		orderDTO.setPayment_status(orderEntity.getPayment_status());
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		ProductEntity_TO_ProductDTO productEntity_TO_productDTO = new ProductEntity_TO_ProductDTO();
		for (ProductOrderEntity x : orderEntity.getProductOrders()) {
			result.add(productEntity_TO_productDTO.toDTO(x.getProduct()));
		}
		orderDTO.setProduct(result);
		return orderDTO;
	}

	public OrderEntity toEntity(Long userid, OrderDTO orderDTO) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity = orderRepository.findOne(orderDTO.getId());
		orderEntity.setOrder_date(orderDTO.getOrder_date());
		orderEntity.setDiscount(orderDTO.getDiscount());
		orderEntity.setTotal_price(orderDTO.getTotal_price());
		orderEntity.setPayment_status(orderDTO.getPayment_status());
		List<ProductOrderEntity> productOrderEntity_list = new ArrayList<ProductOrderEntity>();
		for (ProductDTO x : orderDTO.getProduct()) {
			ProductOrderEntity productOrderEntity = new ProductOrderEntity();
			productOrderEntity.setProduct(productEntity_TO_ProductDTO.toEntity(x));
			productOrderEntity.setOrder(orderRepository.findOne(orderDTO.getId()));
			productOrderEntity.setQuantity(x.getQuantity());
			productOrderEntity_list.add(productOrderEntity);
		}
		orderEntity.setProductOrders(productOrderEntity_list);
		orderEntity.setCustomer(userRepository.findOne(userid));
		orderRepository.save(orderEntity);
		return orderEntity;
	}
}
