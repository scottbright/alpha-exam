package com.alpha.exam.exam.controller;

import com.alpha.exam.exam.dto.ProductDTO;
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
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

  @Mock
  private ProductService productService;

  @InjectMocks
  private ProductController productController;

  @Test
  void should_return_response_with_status_code_201_when_call_get_api_given_request_param() {
    //Given
    String continent = "asia";
    List<ProductDTO> productDTOList = newArrayList(ProductDTO.builder()
        .id(UUID.fromString("da78e2f8-3e50-4b36-acac-de735aff9b78"))
        .price(BigDecimal.ONE)
        .multiplier(new BigDecimal("2"))
        .multipliedValue(new BigDecimal("2.000000"))
        .continent("asia")
        .createdAt("2020-03-01T00:00:00.000")
        .build());
    when(productService.getProducts(continent)).thenReturn(productDTOList);

    //When
    ResponseEntity<List<ProductDTO>> actual = productController.getProducts(continent);

    //Then
    verify(productService).getProducts(continent);
    List<ProductDTO> expected = productDTOList;
    assertEquals(expected, actual.getBody());
    assertEquals(HttpStatus.OK, actual.getStatusCode());

  }
}