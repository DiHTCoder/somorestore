package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Key.ProductOrderKey;
import com.backend.entity.ProductOrderEntity;

public interface ProductOrderRepository extends JpaRepository<ProductOrderEntity, ProductOrderKey> {

}
