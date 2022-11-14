package com.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Key.ProductOrderKey;
import com.backend.convert.OrderEntity_TO_OrderDTO;
import com.backend.convert.ProductEntity_TO_ProductDTO;
import com.backend.convert.UserEntity_TO_UserDTO;
import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;
import com.backend.dto.UserDTO;
import com.backend.entity.CustomerEntity;
import com.backend.entity.LoginEntity;
import com.backend.entity.OrderEntity;
import com.backend.entity.ProductEntity;
import com.backend.entity.ProductOrderEntity;
import com.backend.repository.CustomerRepository;
import com.backend.repository.LoginRepository;
import com.backend.repository.OrderRepository;
import com.backend.repository.ProductOrderRepository;
import com.backend.repository.ProductRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private CustomerRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private LoginRepository loginRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductOrderRepository productOrderRepository;
	@Autowired
	private UserEntity_TO_UserDTO userEntity_TO_userDTO;
	@Autowired
	private OrderEntity_TO_OrderDTO orderEntity_TO_orderDTO;
	@Autowired
	private ProductEntity_TO_ProductDTO productEntity_TO_ProductDTO;

	@Override
	public UserDTO getInfoUser(Long id) {
		try {
			UserDTO user = new UserDTO();
			CustomerEntity customerEntity = userRepository.findOne(id);
			user = userEntity_TO_userDTO.toDTO(customerEntity);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String updateInfoUser(Long id, UserDTO userDTO) {
		try {
			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity = userEntity_TO_userDTO.toEntity(id, userDTO);
			return "true";
		} catch (Exception e) {
			return e.toString();
		}

	}

	@Override
	public List<OrderDTO> getInfoBillUser(Long id) {
		List<OrderDTO> result = new ArrayList<OrderDTO>();
		List<OrderEntity> get = (List<OrderEntity>) orderRepository.findAll();
		List<OrderEntity> filter = new ArrayList<OrderEntity>();
		for (OrderEntity x : get) {
			if (x.getCustomer().getId() == id)
				filter.add(x);
		}
		for (OrderEntity x : filter) {
			result.add(orderEntity_TO_orderDTO.toDTO(x));
		}
		return result;
	}

	@Override
	public String addNewBill(Long userid, OrderDTO orderDTO) {  //chua xong
		try {
			OrderEntity orderEntity = new OrderEntity();
			orderEntity.setOrder_date(orderDTO.getOrder_date());
			orderEntity.setDiscount(orderDTO.getDiscount());
			orderEntity.setTotal_price(orderDTO.getTotal_price());
			orderEntity.setPayment_status(orderDTO.getPayment_status());
			List<ProductOrderEntity> productOrderEntity_list = new ArrayList<ProductOrderEntity>();
			orderEntity.setCustomer(userRepository.findOne(userid));
			for (ProductDTO x : orderDTO.getProduct()) {
				ProductOrderEntity productOrderEntity = new ProductOrderEntity();
				productOrderEntity.setProduct(productRepository.findOne(x.getId()));
				productOrderEntity.setOrder(orderEntity);
				productOrderEntity.setQuantity(x.getQuantity());
				productOrderEntity_list.add(productOrderEntity);
				//productOrderRepository.save(productOrderEntity);
			}
			orderEntity.setProductOrders(productOrderEntity_list);
			orderRepository.save(orderEntity);
			return "true";
		} catch (Exception e) {
			return e.toString();
		}
	}

	@Override
	public String deleteBill(Long userid, Long billid) {
		try {
			OrderEntity orderEntity = new OrderEntity();
			orderEntity = orderRepository.findOne(billid);
			for (ProductOrderEntity x: orderEntity.getProductOrders()) {
				productOrderRepository.delete(x);
			}
			CustomerEntity customerEntity = new CustomerEntity();
			customerEntity = userRepository.findOne(userid);
			for (OrderEntity x: customerEntity.getOrders()) {
				if (x.getId() == billid)
					orderRepository.delete(x);
			}
			return "true";
		} catch (Exception e) {
			return e.toString();
		}
	}

	@Override
	public String addProductToBill(Long userid, Long billid, ProductDTO productDTO) { // chua xong
		try {
			OrderEntity orderEntity = orderRepository.findOne(billid);
			List<ProductOrderEntity> productOrderEntity_list = new ArrayList<ProductOrderEntity>();
			productOrderEntity_list = orderEntity.getProductOrders();
			ProductOrderEntity productOrderEntity = new ProductOrderEntity();
			ProductOrderKey productOrderKey = new ProductOrderKey();
			productOrderKey.setOrder_id(billid);
			productOrderKey.setProduct_id(productDTO.getId());
			productOrderEntity.setId(productOrderKey);
			productOrderEntity.setProduct(productRepository.findOne(productDTO.getId()));
			productOrderEntity.setQuantity(productDTO.getQuantity());	
			productOrderEntity_list.add(productOrderEntity);
			orderEntity.setProductOrders(productOrderEntity_list);
			ProductEntity productEntity = productRepository.findOne(productDTO.getId());
			List <ProductOrderEntity> product = productEntity.getProductOrders();
			product.add(productOrderEntity);
			productEntity.setProductOrders(product);
			productOrderRepository.save(productOrderEntity);
			productRepository.save(productEntity);
			orderRepository.save(orderEntity);
			return "true";
		} catch (Exception e) {
			return e.toString();
		}
	}

	@Override
	public Boolean updateProductToBill(Long userid, Long billid, ProductDTO productDTO) {
		try {
			OrderEntity orderEntity = orderRepository.findOne(billid);
			List<ProductOrderEntity> ls = orderEntity.getProductOrders();
			for (ProductOrderEntity x : ls) {
				if (x.getProduct().getId() == productDTO.getId()) {
					x.setQuantity(productDTO.getQuantity());
					productOrderRepository.save(x);
				}
			}
			orderEntity.setProductOrders(ls);
			orderRepository.save(orderEntity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteProductToBill(Long userid, Long billid, ProductDTO productDTO) {
		try {
			OrderEntity orderEntity = orderRepository.findOne(billid);
			List<ProductOrderEntity> ls = orderEntity.getProductOrders();
			List<ProductOrderEntity> result = new ArrayList<ProductOrderEntity>();
			for (ProductOrderEntity x : ls) {
				if (x.getProduct().getId() == productDTO.getId()) {
					productOrderRepository.delete(x);
				}
				else result.add(x);
			}
			orderEntity.setProductOrders(result);
			orderRepository.save(orderEntity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
