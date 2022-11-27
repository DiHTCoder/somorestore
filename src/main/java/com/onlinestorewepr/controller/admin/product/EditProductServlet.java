package com.onlinestorewepr.controller.admin.product;

import com.onlinestorewepr.entity.Category;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.service.CategoryService;
import com.onlinestorewepr.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet({"/admin/edit-product","/edit-product"})
public class EditProductServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    CategoryService categoryService = new CategoryService();
    List<Category> categories = categoryService.getAllCategories();
    req.setAttribute("categories", categories);
    req.setAttribute("action", "edit");
    req.getRequestDispatcher("/admin/update-product.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int categoryId = Integer.parseInt(req.getParameter("category-id"));
    String name = req.getParameter("name").trim();
    String imagePart = req.getParameter("image");
//    String imagePath = req.getServletContext().getRealPath("\\image");
    String description = req.getParameter("description").trim();
    int price = Integer.parseInt(req.getParameter("price"));
    int discount = Integer.parseInt(req.getParameter("discount"));
    int quantity = Integer.parseInt(req.getParameter("quantity"));
    String size = req.getParameter("size").trim();
    String color = req.getParameter("color").trim();
    String brand = req.getParameter("brand").trim();
    int productid =Integer.parseInt(req.getParameter("id"));
    if (productid>0) {
      ProductService productService = new ProductService(req,resp);
      productService.updateProduct(productid,brand,color,size,quantity,discount,price,description,imagePart,name,categoryId);
//      req.setAttribute("product", product);
      req.setAttribute("action", "edit");
    }
    req.getRequestDispatcher("/admin/product.jsp").forward(req, resp);
  }
}
