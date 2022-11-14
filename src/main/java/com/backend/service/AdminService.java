package com.backend.service;

import java.util.List;

import com.backend.dto.ProductDTO;
import com.backend.dto.UserDTO;

public interface AdminService {
	List<UserDTO> getAll();
	Boolean addNewProduct(ProductDTO productDTO);
	Boolean updateProduct(ProductDTO productDTO);
	Boolean deleteProduct(ProductDTO productDTO);
	Boolean updateuser(UserDTO userDTO);
}
