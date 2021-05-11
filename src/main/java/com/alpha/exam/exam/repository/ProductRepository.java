package com.alpha.exam.exam.repository;


import com.alpha.exam.exam.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findByContinent(String continent);
}
