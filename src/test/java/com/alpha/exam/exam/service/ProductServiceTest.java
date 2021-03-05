package com.alpha.exam.exam.service;

import com.alpha.exam.exam.dto.ProductDTO;
import com.alpha.exam.exam.entity.ProductEntity;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

  @Mock
  private ProductRepository productRepository;

  @InjectMocks
  private ProductService productService;

  @Test
  void should_return_products_when_call_getProducts_given_continent_exist() {
    //Given
    String continent = "asia";
    when(productRepository.findAllByContinent(continent)).thenReturn(newArrayList(ProductEntity.builder()
        .id(UUID.fromString("da78e2f8-3e50-4b36-acac-de735aff9b78"))
        .price("1")
        .multiplier("2")
        .continent("asia")
        .createdAt(LocalDateTime.parse("2020-03-01T00:00:00"))
        .build()));

    //When
    List<ProductDTO> actual = productService.getProducts(continent);

    //Then
    List<ProductDTO> expected = newArrayList(ProductDTO.builder()
        .id(UUID.fromString("da78e2f8-3e50-4b36-acac-de735aff9b78"))
        .price(BigDecimal.ONE)
        .multiplier(new BigDecimal("2"))
        .multipliedValue(new BigDecimal("2.000000"))
        .continent("asia")
        .createdAt("2020-03-01T00:00:00.000")
        .build());
    assertEquals(expected, actual);
  }
}