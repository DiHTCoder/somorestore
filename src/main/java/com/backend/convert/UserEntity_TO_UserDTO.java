package com.backend.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.dto.UserDTO;
import com.backend.entity.CustomerEntity;
import com.backend.entity.LoginEntity;
import com.backend.repository.CustomerRepository;
import com.backend.repository.LoginRepository;

@Component
public class UserEntity_TO_UserDTO {
	@Autowired
	private CustomerRepository userRepository;
	@Autowired
	private LoginRepository loginRepository;

	public UserDTO toDTO(CustomerEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setName(userEntity.getName());
		userDTO.setPhone(userEntity.getPhone());
		userDTO.setAddress(userEntity.getAddress());
		userDTO.setSex(userEntity.getSex());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setImage(userEntity.getImage());
		userDTO.setStatus(userEntity.getStatus());
		userDTO.setUsername(userEntity.getLogin().getUsername());
		userDTO.setPassword(userEntity.getLogin().getPassword());
		userDTO.setRole(userEntity.getLogin().getRole());
		return userDTO;
	}

	public CustomerEntity toEntity(Long id, UserDTO userDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity = userRepository.findOne(id);
		customerEntity.setName(userDTO.getName());
		customerEntity.setPhone(userDTO.getPhone());
		customerEntity.setAddress(userDTO.getAddress());
		customerEntity.setSex(userDTO.getSex());
		customerEntity.setEmail(userDTO.getEmail());
		customerEntity.setImage(userDTO.getImage());
		customerEntity.setStatus(userDTO.getStatus());
		List<LoginEntity> login_list = new ArrayList<LoginEntity>();
		login_list = loginRepository.findAll();
		LoginEntity login = new LoginEntity();
		for (LoginEntity x: login_list) {
			if (x.getCustomer().getId() == id && x.getUsername().equals(customerEntity.getLogin().getUsername()) &&
					x.getPassword().equals(customerEntity.getLogin().getPassword()) ) {
				login = x;
				break;
			}
		}
		login.setUsername(userDTO.getUsername());
		login.setPassword(userDTO.getPassword());
		userRepository.save(customerEntity);
		return customerEntity;
	}
}
