package com.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.backend.convert.OrderEntity_TO_OrderDTO;
import com.backend.convert.ProductEntity_TO_ProductDTO;
import com.backend.convert.UserEntity_TO_UserDTO;
import com.backend.dto.ProductDTO;
import com.backend.dto.UserDTO;
import com.backend.entity.CustomerEntity;
import com.backend.repository.CustomerRepository;
import com.backend.repository.OrderRepository;
import com.backend.repository.ProductRepository;

public class AdminServiceImpl implements AdminService {
	@Autowired
	private CustomerRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private UserEntity_TO_UserDTO userEntity_TO_userDTO;
	@Autowired
	private OrderEntity_TO_OrderDTO orderEntity_TO_orderDTO;
	@Autowired
	private ProductEntity_TO_ProductDTO productEntity_TO_ProductDTO;
	@Autowired
	private UserEntity_TO_UserDTO userEntity_TO_UserDTO;

	@Override
	public List<UserDTO> getAll() {
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (CustomerEntity x : (List<CustomerEntity>) userRepository.findAll()) {
			result.add(userEntity_TO_userDTO.toDTO(x));
		}
		return result;
	}

	@Override
	public Boolean addNewProduct(ProductDTO productDTO) {
		try {

			productRepository.save(productEntity_TO_ProductDTO.toEntity(productDTO));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateProduct(ProductDTO productDTO) {
		try {
			productRepository.save(productEntity_TO_ProductDTO.toEntity(productDTO));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteProduct(ProductDTO productDTO) {
		try {
			productRepository.delete(productDTO.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateuser(UserDTO userDTO) {
		try {
			userRepository.save(userEntity_TO_UserDTO.toEntity(userDTO.getId(), userDTO));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
