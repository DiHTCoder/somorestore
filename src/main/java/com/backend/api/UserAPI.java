package com.backend.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.OrderDTO;
import com.backend.dto.ProductDTO;
import com.backend.dto.UserDTO;
import com.backend.service.UserServiceImpl;

@RestController
public class UserAPI {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/api/user/{id}") // Hien thi thong tin nguoi dung
	public UserDTO getUser(@PathVariable Long id) {
		UserDTO user = new UserDTO();
		user = userServiceImpl.getInfoUser(id);
		return user;
	}

	@PutMapping("/api/user/{id}") // Sua thong tin nguoi dung
	public String updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
		String s =  userServiceImpl.updateInfoUser(id, userDTO);
		return s;
	}

	@GetMapping("/api/user/{userid}/bill") // Hien thi tat ca don hang cua nguoi dung
	public List<OrderDTO> getAllBill(@PathVariable Long userid) {
		List<OrderDTO> orderDTO = new ArrayList<OrderDTO>();
		orderDTO = userServiceImpl.getInfoBillUser(userid);
		return orderDTO;
	}

	@PostMapping("/api/user/{userid}/bill") // Them don hang moi
	public String addOrder(@PathVariable Long userid, @RequestBody OrderDTO orderDTO) {
		return userServiceImpl.addNewBill(userid, orderDTO);
	}

	@DeleteMapping("/api/user/{userid}/bill/{billid}") // Xoa don hang
	public String deleteBill(@PathVariable Long userid, @PathVariable Long billid) {
		return userServiceImpl.deleteBill(userid, billid);
	}

	@PostMapping("/api/user/{userid}/bill/{billid}/product") // Them san pham vao gio hang
	public String addProductToOrder(@PathVariable Long userid, @PathVariable Long billid,
			@RequestBody ProductDTO productDTO) {
		return userServiceImpl.addProductToBill(userid, billid, productDTO);
	}

	@PutMapping("/api/user/{userid}/bill/{billid}/product") // Sua san pham trong gio hang
	public Boolean updateProduct(@PathVariable Long userid, @PathVariable Long billid,
			@RequestBody ProductDTO productDTO) {
		return userServiceImpl.updateProductToBill(userid, billid, productDTO);
	}

	@DeleteMapping("/api/user/{userid}/bill/{billid}/product") // Xoa san pham trong gio hang
	public Boolean deleteProduct(@PathVariable Long userid, @PathVariable Long billid,
			@RequestBody ProductDTO productDTO) {
		return userServiceImpl.deleteProductToBill(userid, billid, productDTO);
	}

}
