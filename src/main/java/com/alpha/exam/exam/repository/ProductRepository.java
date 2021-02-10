package com.alpha.exam.exam.repository;

import com.alpha.exam.exam.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

  List<ProductEntity> findAllByContinent(String continent);

}
