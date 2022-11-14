package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Key.ProductSizeKey;
import com.backend.entity.ProductSizeEntity;

public interface ProductSizeRepository extends JpaRepository<ProductSizeEntity, ProductSizeKey> {

}
