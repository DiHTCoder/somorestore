package com.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.convert.OrderEntity_TO_OrderDTO;
import com.backend.convert.ProductEntity_TO_ProductDTO;
import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;
import com.backend.entity.OrderEntity;
import com.backend.entity.ProductEntity;
import com.backend.repository.OrderRepository;
import com.backend.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository product;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductEntity_TO_ProductDTO productDTO;
	@Autowired
	private OrderEntity_TO_OrderDTO orderEntity_TO_orderDTO;

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		List<ProductEntity> get = new ArrayList<ProductEntity>();
		get = (List<ProductEntity>) product.findAll();
		for (ProductEntity x : get) {
			ProductDTO product = productDTO.toDTO(x);
			result.add(product);
		}
		return result;
	}

	@Override
	public List<ProductDTO> findByDiscount() {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductDTO x : find) {
			if (x.getDiscount() > 0.)
				result.add(x);
		}
		return result;
	}

	@Override
	public List<ProductDTO> findByHot() {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		find.sort((o1, o2) -> {
			return (int) ((Long) o2.getSold_quantity() - o1.getSold_quantity());
		});
		int i = 0;
		for (ProductDTO x : find) {
			result.add(x);
			if (i == 99)
				return result;
			i++;
		}
		return result;
	}

	@Override
	public List<ProductDTO> findByBrand(String brand) {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductDTO x : find) {
			String s = x.getBrand();
			if (s.equals(brand))
				result.add(x);
		}
		return result;	
	}

	@Override
	public List<ProductDTO> findByCategory(String category) {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductDTO x : find) {
			if (x.getCategory().equals(category))
				result.add(x);
		}
		return result;	
	}

	@Override
	public List<ProductDTO> findByName(String name) {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductDTO x : find) {
			if (x.getName().contains(name))
				result.add(x);
		}
		return result;	
	}

	@Override
	public List<ProductDTO> findByPrice(Long price) {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductDTO x : find) {
			if (x.getPrice() == price)
				result.add(x);
		}
		return result;	
	}

	@Override
	public List<ProductDTO> findBySize(Double size) {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductDTO x : find) {
			if (x.getSize().contains(size))
				result.add(x);
		}
		return result;	
	}

	@Override
	public List<ProductDTO> findByColor(String color) {
		List<ProductDTO> find = findAll();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (ProductDTO x : find) {
			if (x.getColor().contains(color))
				result.add(x);
		}
		return result;	
	}

	@Override
	public List<OrderDTO> findByBill() {
		List<OrderDTO> result = new ArrayList<OrderDTO>();
		List<OrderEntity> get = (List<OrderEntity>) orderRepository.findAll();
		List<OrderEntity> filter = new ArrayList<OrderEntity>();
		for (OrderEntity x : get) {
				filter.add(x);
		}
		for (OrderEntity x : filter) {
			result.add(orderEntity_TO_orderDTO.toDTO(x));
		}
		return result;
	}

}
