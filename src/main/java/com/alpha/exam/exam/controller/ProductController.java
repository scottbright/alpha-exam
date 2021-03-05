package com.alpha.exam.exam.controller;

import com.alpha.exam.exam.model.dto.ProductDTO;
import com.alpha.exam.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  public ResponseEntity<List<ProductDTO>> getProducts(String continent) {

    List<ProductDTO> products = productService.getProducts(continent);

    return ResponseEntity.status(HttpStatus.OK).body(products);
  }
}
