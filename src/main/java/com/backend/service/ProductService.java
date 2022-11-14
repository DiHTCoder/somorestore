package com.backend.service;

import java.util.List;

import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> findAll();

	List<ProductDTO> findByDiscount();

	List<ProductDTO> findByHot();

	List<ProductDTO> findByBrand(String brand);

	List<ProductDTO> findByCategory(String category);

	List<ProductDTO> findByName(String name);

	List<ProductDTO> findByPrice(Long price);

	List<ProductDTO> findBySize(Double size);

	List<ProductDTO> findByColor(String color);

	List<OrderDTO> findByBill();
}
