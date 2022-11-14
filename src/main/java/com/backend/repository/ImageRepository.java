package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Long> {

}
