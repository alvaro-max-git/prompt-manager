package com.alvaromax.prompt_manager.models;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Template {

  @Id @GeneratedValue private Long id;
  @NotBlank private String name;
  @Lob @NotBlank private String bodyMarkdown; // con {{vars}} y secciones
  private String tags; // "salud,fitness" --> hay que normalizarlo.
  @CreationTimestamp private Instant createdAt;
  @UpdateTimestamp private Instant updatedAt;
  
}

