package com.alpha.exam.exam.controller;

import com.alpha.exam.exam.model.dto.ProductDTO;
import com.alpha.exam.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/product")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam String continent) {

    List<ProductDTO> products = productService.getProducts(continent);

    return ResponseEntity.status(HttpStatus.OK).body(products);
  }
}
