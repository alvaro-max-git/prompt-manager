package com.alvaromax.prompt_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaromax.prompt_manager.domain.ContextDoc;

public interface ContextDocRepository extends JpaRepository <ContextDoc, Long> {
}
