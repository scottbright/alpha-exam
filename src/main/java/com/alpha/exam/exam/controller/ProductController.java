package com.alpha.exam.exam.controller;

import com.alpha.exam.exam.dto.ProductDTO;
import com.alpha.exam.exam.request.ProductRequest;
import com.alpha.exam.exam.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/product")
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class ProductController {

  private final ProductService productService;

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getProducts(@RequestParam String continent) {
    List<ProductDTO> productDTOList = productService.getProducts(continent);
    return ResponseEntity.status(HttpStatus.OK).body(productDTOList);
  }

  @PostMapping
  public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductRequest productRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productRequest));
  }

}
