package com.alvaromax.prompt_manager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;

@Entity
public class ContextDoc extends BaseEntity {

    @Id @GeneratedValue private Long id;
    @NotBlank private String name;
    @Lob @NotBlank private String bodyMarkdown;
    private boolean sensitive;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBodyMarkdown() {
        return bodyMarkdown;
    }
    public void setBodyMarkdown(String bodyMarkdown) {
        this.bodyMarkdown = bodyMarkdown;
    }
    public boolean isSensitive() {
        return sensitive;
    }
    public void setSensitive(boolean sensitive) {
        this.sensitive = sensitive;
    }

}