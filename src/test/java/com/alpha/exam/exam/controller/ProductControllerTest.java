package com.alpha.exam.exam.controller;

import com.alpha.exam.exam.model.dto.ProductDTO;
import com.alpha.exam.exam.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

  @Mock
  private ProductService productService;

  @InjectMocks
  private ProductController productController;

  @Test
  void should_return_response_with_http_status_200_when_call_get_products_given_continent() {
    //Given
    String continent = "asia";
    when(productService.getProducts(continent)).thenReturn(newArrayList(ProductDTO.builder()
        .id("5c65721f-c21b-824f-add3-4539a3be815b")
        .price(new BigDecimal("555.123"))
        .continent("asia")
        .multiplier(new BigDecimal("4"))
        .createdAt("2021-01-03T00:00:00.123")
        .multipliedValue(new BigDecimal("2220.492000"))
        .build()));

    //When
    ResponseEntity<List<ProductDTO>> actual = productController.getProducts(continent);

    //Then
    List<ProductDTO> expected = newArrayList(ProductDTO.builder()
        .id("5c65721f-c21b-824f-add3-4539a3be815b")
        .price(new BigDecimal("555.123"))
        .continent("asia")
        .multiplier(new BigDecimal("4"))
        .createdAt("2021-01-03T00:00:00.123")
        .multipliedValue(new BigDecimal("2220.492000"))
        .build());

    assertEquals(HttpStatus.OK, actual.getStatusCode());
    assertEquals(expected, actual.getBody());
    verify(productService).getProducts(continent);
  }
}
