package com.alpha.exam.exam.mapper;

import com.alpha.exam.exam.model.dto.ProductDTO;
import com.alpha.exam.exam.model.entity.ProductEntity;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductMapperTest {

  @Test
  void should_return_productDTOs_when_call_mapEntitiesToDTOs_given_productEntities() {
    //Given
    List<ProductEntity> productEntityList = newArrayList(ProductEntity.builder()
        .id(UUID.fromString("5c65721f-c21b-824f-add3-4539a3be815b"))
        .price("555.123")
        .continent("asia")
        .multiplier("4")
        .createdAt(LocalDateTime.parse("2021-01-03T00:00:00.123"))
        .build());

    //When
    List<ProductDTO> actual = ProductMapper.mapEntitiesToDTOs(productEntityList);

    //Then
    List<ProductDTO> expected = newArrayList(ProductDTO.builder()
        .id("5c65721f-c21b-824f-add3-4539a3be815b")
        .price(new BigDecimal("555.123"))
        .continent("asia")
        .multiplier(new BigDecimal("4"))
        .createdAt("2021-01-03T00:00:00.123")
        .build());

    assertEquals(expected, actual);
  }
}