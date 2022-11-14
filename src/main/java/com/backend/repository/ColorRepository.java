package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.ColorEntity;

public interface ColorRepository extends JpaRepository<ColorEntity, Long>{

}
