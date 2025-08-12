package com.alvaromax.prompt_manager.web.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RenderRequest {

    @NotNull private Long templateId;
    private Map<String, Object> variables = new HashMap<>();
    private List<Long> contextIds;
    private Long styleId;
    private String extrasMarkdown;  // opcional

}
