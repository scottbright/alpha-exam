package com.alpha.exam.exam.controller;


import com.alpha.exam.exam.model.Product;
import com.alpha.exam.exam.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("v1/product")
    public Product getProductByContinent(@RequestParam("continent") String continent) {
        return productService.findProductByContinent(continent);
    }
}
