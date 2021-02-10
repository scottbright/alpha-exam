package com.alpha.exam.exam.transformer;

import com.alpha.exam.exam.dto.ProductDTO;
import com.alpha.exam.exam.entity.ProductEntity;
import com.alpha.exam.exam.request.ProductRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

public class ProductTransformer {

  static public ProductDTO transformEntityToDTO(ProductEntity productEntity) {
    return ProductDTO.builder()
        .id(productEntity.getId())
        .continent(productEntity.getContinent())
        .createdAt(productEntity.getCreatedAt())
        .multiplier(new BigDecimal(productEntity.getMultiplier()))
        .price(new BigDecimal(productEntity.getPrice()))
        .multipliedValue(new BigDecimal(productEntity.getMultiplier()).multiply(new BigDecimal(productEntity.getPrice())).setScale(6, RoundingMode.FLOOR))
        .build();
  }

  static public ProductEntity transformRequestToEntity(ProductRequest productRequest) {
    return ProductEntity.builder()
        .id(UUID.randomUUID())
        .continent(productRequest.getContinent())
        .multiplier(productRequest.getMultiplier().toString())
        .price(productRequest.getPrice().toString())
        .build();
  }

}
