package com.alvaromax.prompt_manager.domain;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
  @CreationTimestamp @Column(updatable = false) protected Instant createdAt;
  @UpdateTimestamp protected Instant updatedAt;
}
