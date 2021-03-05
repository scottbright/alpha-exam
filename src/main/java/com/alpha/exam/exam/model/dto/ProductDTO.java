package com.alpha.exam.exam.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

  private String id;

  private BigDecimal price;

  private String continent;

  private BigDecimal multiplier;

  private String createdAt;

}
