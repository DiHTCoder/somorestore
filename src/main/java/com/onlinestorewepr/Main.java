package com.onlinestorewepr;

import com.onlinestorewepr.dao.UserDAO;
import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.User;
import com.onlinestorewepr.service.CategoryService;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    UserDAO userDAO = new UserDAO();
    User user = new User();

    user.setName("ma33");
    user.setAddress("Binh Dinh");
    user.setAdmin(false);
    user.setGender("Nam");
    user.setUsername("admin");
    user.setPassword("1234526");
    user.setPhone("03726396211");

    userDAO.insert(user);
  }
}
