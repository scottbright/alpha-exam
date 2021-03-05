package com.alpha.exam.exam.mapper;

import com.alpha.exam.exam.model.dto.ProductDTO;
import com.alpha.exam.exam.model.entity.ProductEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

  public static List<ProductDTO> mapEntitiesToDTOs(List<ProductEntity> productEntityList) {
    return productEntityList.stream()
        .map(productEntity -> ProductDTO.builder()
            .id(productEntity.getId().toString())
            .price(new BigDecimal(productEntity.getPrice()))
            .continent(productEntity.getContinent())
            .multiplier(new BigDecimal(productEntity.getMultiplier()))
            .createdAt(productEntity.getCreatedAt().toString())
            .multipliedValue((new BigDecimal(productEntity.getPrice())).multiply(new BigDecimal(productEntity.getMultiplier())).setScale(6, RoundingMode.FLOOR))
            .build())
        .collect(Collectors.toList());
  }
}
