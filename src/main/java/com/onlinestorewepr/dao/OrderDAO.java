package com.onlinestorewepr.dao;

import com.onlinestorewepr.entity.Order;
import com.onlinestorewepr.entity.Product;
import com.onlinestorewepr.entity.User;
import com.onlinestorewepr.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
   public void insert(Order order) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.save(order);

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public void update(Order order) {
      Transaction transaction = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         transaction = session.beginTransaction();

         session.update(order);

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

         Order order = session.get(Order.class, id);
         if (order != null) {
            session.delete(order);
         }

         transaction.commit();
      } catch (Exception e) {
         e.printStackTrace();
         if (transaction != null) {
            transaction.rollback();
         }
      }
   }

   public List<Order> getAll() {
      List<Order> orders = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Order> criteriaQuery = builder.createQuery(Order.class);
         criteriaQuery.from(Order.class);
         orders = session.createQuery(criteriaQuery).getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return orders;
   }

   public List<Order> getConfirmOrders(){
      List<Order> orders = new ArrayList<>();
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "select o from Order o where o.status = 'Đã xác nhận'";
         Query query = session.createQuery(HQL);
         orders = query.getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return orders;
   }
   public List<Order> getDeliveringOrders(){
      List<Order> orders = new ArrayList<>();
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "select o from Order o where o.status = 'Đang giao hàng'";
         Query query = session.createQuery(HQL);
         orders = query.getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return orders;
   }
   public List<Order> getDoneOrders(){
      List<Order> orders = new ArrayList<>();
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         String HQL = "select o from Order o where o.status = 'Giao hàng thành công' or o.status = 'Giao hàng không thành công' ";
         Query query = session.createQuery(HQL);
         orders = query.getResultList();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return orders;
   }
   public List<Order> getOrderByUser(User user)
   {
      List<Order> orders = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {
         session.beginTransaction();
         CriteriaBuilder builder = session.getCriteriaBuilder();
         CriteriaQuery<Order> query = builder.createQuery(Order.class);
         Root<Order> root = query.from(Order.class);
         query.select(root); // SELECT
         query.where(builder.equal(root.get("user"), user));
         orders = session.createQuery(query).list();
         session.getTransaction().commit();

      } catch (Exception e) {
         e.printStackTrace();
      }
      return orders;
   }
   public Order get(int id) {
      Order order = null;
      try (Session session = HibernateUtil.getSessionFactory().openSession()) {

         order = session.get(Order.class, id);

      } catch (Exception e) {
         e.printStackTrace();
      }
      return order;
   }
}
