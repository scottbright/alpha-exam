package com.alpha.exam.exam.controller;


import com.alpha.exam.exam.model.Product;
import com.alpha.exam.exam.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product")
    public ResponseEntity<List<Product>> getProductByContinent(@RequestParam("continent") String continent) {
        return ResponseEntity.ok(productService.findProductByContinent(continent));
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insertProduct(product));
    }
}
