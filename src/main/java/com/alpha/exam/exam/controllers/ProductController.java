package com.alpha.exam.exam.controllers;


import com.alpha.exam.exam.entities.ProductEntity;
import com.alpha.exam.exam.models.ProductModel;
import com.alpha.exam.exam.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/v1/product")
    List<ProductEntity> getProduct(@RequestParam String continent) {
        //ProductEntity product =  productRepository.findByContinent(continent);

        //TODO return entity as json
        return productRepository.findByContinent(continent);
    }

    @PostMapping("/v1/product")
    ProductEntity getProduct(@RequestBody ProductModel productModel) {
        //ProductEntity product =  productRepository.findByContinent(continent);

        String pattern = "yyyy-MM-dd'T'HH:mm:ssSSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        //simpleDateFormat.format(new Date());

        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());

        String t = timestamp2.toString();
        ProductEntity productEntity = ProductEntity.builder()
                .id(UUID.randomUUID().toString())
                .price(productModel.getPrice())
                .continent(productModel.getContinent())
                .multiplier(productModel.getMultiplier())
                .createdAt(t)
                .build();

        //TODO return entity as json
        return productRepository.save(productEntity);
    }


}
