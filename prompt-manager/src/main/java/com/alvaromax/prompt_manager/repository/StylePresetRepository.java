package com.alvaromax.prompt_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alvaromax.prompt_manager.domain.StylePreset;

public interface StylePresetRepository extends JpaRepository <StylePreset, Long> {

}
