package com.onlinestorewepr.dao;

import com.onlinestorewepr.entity.ProductImage;
import com.onlinestorewepr.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductImageDAO {
   public void insert(ProductImage productImage) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.save(productImage);

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public void update(ProductImage productImage) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.update(productImage);

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

         ProductImage productImage = session.get(ProductImage.class, id);
         if (productImage != null) {
            session.delete(productImage);
         }

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public List<ProductImage> getAll() {
      List<ProductImage> productImages = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<ProductImage> criteriaQuery = builder.createQuery(ProductImage.class);
         criteriaQuery.from(ProductImage.class);
         productImages = session.createQuery(criteriaQuery).getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return productImages;
   }

   public ProductImage get(int id) {
      ProductImage productImage = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

         productImage = session.get(ProductImage.class, id);

      } catch (Exception e) {
         e.printStackTrace();
      }
      return productImage;
   }
   
   public ProductImage getByIdProduct(int product) {
	      ProductImage productImage = null;
	      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

	         productImage = session.get(ProductImage.class, product);

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return productImage;
	   }
}
