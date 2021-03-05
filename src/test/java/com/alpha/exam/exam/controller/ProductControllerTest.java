package com.alpha.exam.exam.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

  @InjectMocks
  private ProductController productController;

  @Test
  void should_return_response_with_http_status_200_when_call_get_products_given_continent() {
    //Given
    String continent = "asia";

    //When
    ResponseEntity<List<String>> actual = productController.getProducts(continent);

    //Then
    assertEquals(HttpStatus.OK, actual.getStatusCode());
  }
}
