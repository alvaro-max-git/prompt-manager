package com.alvaromax.prompt_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaromax.prompt_manager.models.Template;

public interface TemplateRepository extends JpaRepository<Template,Long> {

}
