package com.alvaromax.prompt_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaromax.prompt_manager.domain.Template;

public interface TemplateRepository extends JpaRepository<Template,Long> {

}
