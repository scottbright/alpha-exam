package com.alpha.exam.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProductController {

  public ResponseEntity<List<String>> getProducts(String continent) {

    return ResponseEntity.status(HttpStatus.OK).body(null);
  }
}
