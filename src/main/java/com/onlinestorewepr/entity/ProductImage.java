package com.onlinestorewepr.entity;
import javax.persistence.*;

@Entity
@Table(name = "productImage")
public class ProductImage {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private int id;
   @Column
   private String url;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "productId", referencedColumnName = "id")
   private Product product;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }
}
