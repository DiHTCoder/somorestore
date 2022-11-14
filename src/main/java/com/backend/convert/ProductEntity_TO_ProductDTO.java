package com.backend.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.dto.ProductDTO;
import com.backend.entity.ColorEntity;
import com.backend.entity.ImageEntity;
import com.backend.entity.ProductColorEntity;
import com.backend.entity.ProductEntity;
import com.backend.entity.ProductOrderEntity;
import com.backend.entity.ProductSizeEntity;
import com.backend.repository.CustomerRepository;
import com.backend.repository.OrderRepository;
import com.backend.repository.ProductColorRepository;
import com.backend.repository.ProductOrderRepository;
import com.backend.repository.ProductRepository;
import com.backend.repository.ProductSizeRepository;

@Component
public class ProductEntity_TO_ProductDTO {
	@Autowired
	private CustomerRepository userRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductOrderRepository productOrderRepository;
	@Autowired
	private ProductColorRepository productColorRepository;
	@Autowired
	private ProductSizeRepository productSizeRepository;
	@Autowired
	private UserEntity_TO_UserDTO userEntity_TO_userDTO;
	@Autowired
	private ProductEntity_TO_ProductDTO productEntity_TO_ProductDTO;

	public ProductDTO toDTO(ProductEntity productEntity) {
		ProductDTO x = new ProductDTO();
		x.setId(productEntity.getId());
		x.setBrand(productEntity.getBrand().getName());
		x.setCategory(productEntity.getCategory().getName());
		x.setName(productEntity.getName());
		x.setPrice(productEntity.getMoney());
		x.setDiscount(productEntity.getDiscount());
		x.setSold_quantity(x.getSold_quantity());
		x.setStock(productEntity.getStock());
		x.setDescription(productEntity.getDescription());
		List<Double> size = new ArrayList<Double>();
		for (ProductSizeEntity y : productEntity.getProductSizes()) {
			size.add(y.getSize().getSize());
		}
		x.setSize(size);
		List<String> image = new ArrayList<String>();
		for (ImageEntity y : productEntity.getImages()) {
			image.add(y.getImage());
		}
		x.setImage(image);
		List<String> color = new ArrayList<String>();
		for (ProductColorEntity y : productEntity.getProductColors()) {
			color.add(y.getColor().getColor());
		}
		x.setColor(color);
		return x;
	}

	public ProductEntity toEntity(ProductDTO productDTO) {
		ProductEntity x = new ProductEntity();
		x = productRepository.findOne(productDTO.getId());
		/*
		 * if (x != null) { x.setName(productDTO.getName());
		 * x.setMoney(productDTO.getPrice());
		 * x.setSold_quantity(productDTO.getSold_quantity());
		 * x.setDiscount(productDTO.getDiscount()); x.setStock(productDTO.getStock());
		 * x.setDescription(productDTO.getDescription()); List<ProductSizeEntity>
		 * productSizeEntity_list = new ArrayList<ProductSizeEntity>(); for (Double size
		 * : productDTO.getSize()) { ProductSizeEntity productSizeEntity = new
		 * ProductSizeEntity(); productSizeEntity.setProduct(x);
		 * productSizeEntity.setQuantity(productDTO.getQuantity());
		 * 
		 * } for (ProductSizeEntity y: x.getProductSizes()) { y.set } } else {
		 * 
		 * }
		 */
		return x;
	}

}
