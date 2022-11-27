package com.onlinestorewepr.dao;

import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
   public void insert(Product product) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.save(product);

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public void update(Product product) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.update(product);

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public void delete(int id) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         Product product = session.get(Product.class, id);
         if (product != null) {
            session.delete(product);
         }

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public List<Product> getAll() {
//      List<Product> products = null;
//      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//         CriteriaBuilder builder = session.getCriteriaBuilder();
//         CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
//         criteriaQuery.from(Product.class);
//         products = session.createQuery(criteriaQuery).getResultList();
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//      return products;
      List<Product> products = new ArrayList<>();
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "FROM Product order by price asc ";
         Query query = session.createQuery(HQL);
         products = query.getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return products;
   }

   public Product get(int id) {
      Product product = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

         product = session.get(Product.class, id);

      } catch (Exception e) {
         e.printStackTrace();
      }
      return product;
   }

   public Product findByName(String name) {
      Product product = null;

      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "SELECT c FROM Product c WHERE c.name = :name";
         Query query = session.createQuery(HQL);
         query.setParameter("name", name);
         List<Product> products = query.getResultList();
         if (!products.isEmpty()) {
            product = products.get(0);
         }
      } catch (Exception e) {
         e.printStackTrace();
      }

      return product;
   }
   public List<Product> listProductByCategoryId(int cateid){
      List<Product> products = new ArrayList<>();
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "FROM Product p WHERE p.category.id = :cateid" ;
         Query query = session.createQuery(HQL);
         query.setParameter("cateid", cateid);
         products = query.getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return products;
   }
   public List<Product> listArrangeDesc(){
      List<Product> products = new ArrayList<>();
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "FROM Product order by price desc";
         Query query = session.createQuery(HQL);
         products = query.getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return products;
   }
   public Product getProductsByOrderItem(Product pr) {
      Product product = new Product();
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Product> query = builder.createQuery(Product.class);
         Root<Product> root = query.from(Product.class); // FROM User u
         query.select(root); // SELECT
         query.where(builder.equal(root.get("id"), pr.getId())); // WHERE u.id = 1
         product = session.createQuery(query).uniqueResult();

         session.getTransaction().commit();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return product;
   }

   public int total(int a, int b)
   {
      return a*b;
   }
//   public static void main(String[] args) {
//      List<Product> products = null;
//      ProductDAO productDAO = new ProductDAO();
//      products = productDAO.listArrangeDesc();
//      System.out.println(products);
//   }
}
