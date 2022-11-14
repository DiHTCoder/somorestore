package com.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;
import com.backend.entity.ProductEntity;
import com.backend.repository.ProductRepository;
import com.backend.service.ProductServiceImpl;

@RestController
public class ProductAPI {
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private ProductRepository product;

	@GetMapping("/api/product/get_all")
	public List<ProductDTO> allProduct() {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findAll();
		return result;
	}

	@GetMapping("/api/product/discount")
	public List<ProductDTO> discountProduct() {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findByDiscount();
		return result;
	}

	@GetMapping("/api/product/hot")
	public List<ProductDTO> hotProduct() {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findByHot();
		return result;
	}

	@GetMapping("/api/product/brand/{brand}")
	public List<ProductDTO> brandProduct(@PathVariable String brand) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findByBrand(brand);
		return result;
	}

	@GetMapping("/api/product/category/{category}")
	public List<ProductDTO> categoryProduct(@PathVariable String category) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findByCategory(category);
		return result;
	}

	@GetMapping("/api/product/name/{name}")
	public List<ProductDTO> nameProduct(@PathVariable String name) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findByName(name);
		return result;
	}

	@GetMapping("/api/product/price/{price}")
	public List<ProductDTO> priceProduct(@PathVariable Long price) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findByPrice(price);
		return result;
	}

	@GetMapping("/api/product/size/{size}")
	public List<ProductDTO> sizeProduct(@PathVariable Double size) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findBySize(size);
		return result;
	}

	@GetMapping("/api/product/color/{color}")
	public List<ProductDTO> colorProduct(@PathVariable String color) {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		result = productServiceImpl.findByColor(color);
		return result;
	}

	@GetMapping("/api/product/bill")
	public List<OrderDTO> billProduct() {
		List<OrderDTO> result = new ArrayList<OrderDTO>();
		result = productServiceImpl.findByBill();
		return result;
	}
}
