package com.alvaromax.prompt_manager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Template extends BaseEntity{

  @Id @GeneratedValue private Long id;
  @NotBlank private String name;
  @Lob @NotBlank private String bodyMarkdown; // con {{vars}} y secciones
  // private String tags; // "salud,fitness" --> hay que normalizarlo.
  // quizás mejor List<String> tags o List<Tag>


  public Long getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getBodyMarkdown() {
    return bodyMarkdown;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setBodyMarkdown(String bodyMarkdown) {
    this.bodyMarkdown = bodyMarkdown;
  }
  

}

