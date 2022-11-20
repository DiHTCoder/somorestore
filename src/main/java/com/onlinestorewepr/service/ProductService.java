package com.onlinestorewepr.service;

import com.onlinestorewepr.dao.CategoryDAO;
import com.onlinestorewepr.dao.ProductDAO;
import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
  private ProductDAO productDAO = null;
  private CategoryDAO categoryDAO = null;
  private ServiceResult serviceResult = null;
  HttpServletResponse response;
  HttpServletRequest request;

  public ServiceResult getServiceResult() {
    return serviceResult;
  }

  public ProductService(HttpServletRequest request, HttpServletResponse response) {
    this.request =request;
    this.response =response;
    productDAO = new ProductDAO();
    categoryDAO = new CategoryDAO();
    serviceResult = new ServiceResult();
  }

  public void createProduct(int categoryId, String name, Part imagePart, String imagePath, String description, int price, int discount, int quantity, String size, String color, String brand) {
    String message = "", messageType = "";

    // Check if a product with the same name already exists in DB
    if (productDAO.findByName(name) == null) {
      // Check if category exists ?
      Category category = categoryDAO.get(categoryId);
      if (category != null) {
        // If category exists, create a new product
        try {
          // Handle image url
          DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm");
          LocalDateTime now = LocalDateTime.now();
          String fileName =  Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();
          imagePath += "\\" + dateTimeFormatter.format(now).replace('/', '\\');

          Path path = Paths.get(imagePath);
          if (!Files.exists(path))
            Files.createDirectories(path);
          String imageUrl = imagePath + "\\" + fileName;
          // ------

          Product product = new Product(name, imageUrl, description, price, quantity, discount, size, color, brand, category);
          productDAO.insert(product);

          imagePart.write(imageUrl);

          message = "A new product was created successfully!";
          messageType = "success";
        } catch (Exception e) {
          e.printStackTrace();
          message = "An error occurred when creating a new category! Please try again.";
          messageType = "danger";
        }
      } else {
        message = "Category doesn't exist! Please try again.";
        messageType = "danger";
      }
    } else {
      message = String.format("A product with name %s already exists! Please choose another name.", name);
      messageType = "danger";
    }
    serviceResult.setMessage(message);
    serviceResult.setMessageType(messageType);
  }

  public Product getProduct(int id) {
    return productDAO.get(id);
  }

  public void getProductsByCategoryID() throws ServletException, IOException {
    int categoryId = Integer.parseInt(request.getParameter("cid"));
    List<Product> productList = productDAO.getAll();
    List<Category> categoryList = categoryDAO.getAll();
    List<Product> products = null;
     products = productDAO.listProductByCategoryId(categoryId);
     System.out.println(categoryList);

    request.setAttribute("cateList",categoryList);

    request.getRequestDispatcher("/web/index.jsp").forward(request, response);
  }

  public List<Product> getAllProducts() {
    List<Product> products = null;

    products = productDAO.getAll();

    if (products != null) {
      products.sort((o1, o2) -> {
        int compareValue = o1.getName().compareTo(o2.getName());
        return (Integer.compare(compareValue, 0));
      });
    }

    return products;
  }
}
