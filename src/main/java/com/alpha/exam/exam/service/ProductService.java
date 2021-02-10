package com.alpha.exam.exam.service;

import com.alpha.exam.exam.dto.ProductDTO;
import com.alpha.exam.exam.entity.ProductEntity;
import com.alpha.exam.exam.repository.ProductRepository;
import com.alpha.exam.exam.request.ProductRequest;
import com.alpha.exam.exam.transformer.ProductTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductService {

  private final ProductRepository productRepository;

  public List<ProductDTO> getProducts(String continent) {
    return productRepository.findAllByContinent(continent).stream()
        .map(productEntity -> ProductTransformer.transformEntityToDTO(productEntity))
        .collect(Collectors.toList());
  }

  public ProductDTO saveProduct(ProductRequest productRequest) {
    ProductEntity productEntity = ProductTransformer.transformRequestToEntity(productRequest);

    return ProductTransformer.transformEntityToDTO(productRepository.save(productEntity));
  }
}
