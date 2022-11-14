package com.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.ProductDTO;
import com.backend.dto.UserDTO;
import com.backend.entity.ProductColorEntity;
import com.backend.entity.ProductEntity;
import com.backend.entity.ProductOrderEntity;
import com.backend.repository.ProductColorRepository;

@RestController
public class AdminAPI {
	@Autowired
	private ProductColorRepository productColorRepository;
	
	@GetMapping("/api/admin/customer")
	public List<UserDTO> getAllUser() {
		UserDTO user = new UserDTO();
		List<UserDTO> result = new ArrayList<UserDTO>();
		return result;
	}

	@PostMapping("/api/admin/product")
	public boolean addProduct(ProductDTO productDTO) {
		ProductDTO product = new ProductDTO();
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productDTO.getName());
		productEntity.setMoney(productDTO.getPrice());
		productEntity.setSold_quantity(productDTO.getSold_quantity());
		productEntity.setDiscount(productDTO.getDiscount());
		productEntity.setStock(productDTO.getStock());
		productEntity.setDescription(productDTO.getDescription());
		List<ProductOrderEntity> productOrders = new ArrayList<ProductOrderEntity>();
		productEntity.setProductOrders(productOrders);
		List<ProductColorEntity> productColor = new ArrayList<ProductColorEntity>();
		for (String x: productDTO.getColor()) {
			//ProductColorEntity productColorEntity = productColorRepository.findByName(productDTO.getName());
		}
		return true;
	}

	@PutMapping("/api/product/get_all")
	public ProductDTO updateProduct() {
		ProductDTO product = new ProductDTO();
		return product;
	}
}
