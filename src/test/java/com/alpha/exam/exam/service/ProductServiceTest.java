package com.alpha.exam.exam.service;

import com.alpha.exam.exam.model.dto.ProductDTO;
import com.alpha.exam.exam.model.entity.ProductEntity;
import com.alpha.exam.exam.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

  @Test
  void should_return_ProductDTO_list_when_call_getProducts_given_continent() {
    //Given
    String continent = "asia";
    when(productRepository.findAllByContinent(continent)).thenReturn(newArrayList(ProductEntity.builder()
        .id(UUID.fromString("5c65721f-c21b-824f-add3-4539a3be815b"))
        .price("555.123")
        .continent("asia")
        .multiplier("4")
        .createdAt(LocalDateTime.parse("2021-01-03T00:00:00.123"))
        .build()));

    //When
    List<ProductDTO> actual = productService.getProducts(continent);

    //Then
    List<ProductDTO> expected = newArrayList(ProductDTO.builder()
        .id("5c65721f-c21b-824f-add3-4539a3be815b")
        .price(new BigDecimal("555.123"))
        .continent("asia")
        .multiplier(new BigDecimal("4"))
        .createdAt("2021-01-03T00:00:00.123")
        .multipliedValue(new BigDecimal("2220.492000"))
        .build());

    assertEquals(expected, actual);
  }
}