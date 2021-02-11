package com.alpha.exam.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

  private UUID id;

  private BigDecimal price;

  private String continent;

  private BigDecimal multiplier;

  private String createdAt;

  private BigDecimal multipliedValue;

}
