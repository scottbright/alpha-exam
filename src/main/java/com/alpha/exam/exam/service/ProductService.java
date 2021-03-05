package com.alpha.exam.exam.service;

import com.alpha.exam.exam.mapper.ProductMapper;
import com.alpha.exam.exam.model.dto.ProductDTO;
import com.alpha.exam.exam.model.entity.ProductEntity;
import com.alpha.exam.exam.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<ProductDTO> getProducts(String continent) {
    List<ProductEntity> productEntityList = productRepository.findAllByContinent(continent);
    return ProductMapper.mapEntitiesToDTOs(productEntityList);
  }
}
