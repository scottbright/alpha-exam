package com.alpha.exam.exam.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {

  @Id
  @GeneratedValue
  private UUID id;

  private String price;

  private String continent;

  private String multiplier;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

}
