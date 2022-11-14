package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Key.ProductColorKey;
import com.backend.entity.ProductColorEntity;

public interface ProductColorRepository extends JpaRepository<ProductColorEntity, ProductColorKey>{

}
