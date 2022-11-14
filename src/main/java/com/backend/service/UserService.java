package com.backend.service;

import java.util.List;

import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;
import com.backend.dto.UserDTO;

public interface UserService {
	UserDTO getInfoUser(Long id);
	String updateInfoUser(Long id, UserDTO userDTO);
	List<OrderDTO> getInfoBillUser(Long id);
	String addNewBill(Long id, OrderDTO orderDTO);
	String deleteBill(Long userid, Long billid);
	String addProductToBill(Long userid, Long billid, ProductDTO productDTO);
	Boolean updateProductToBill(Long userid, Long billid, ProductDTO productDTO);
	Boolean deleteProductToBill(Long userid, Long billid, ProductDTO productDTO);
}
