package com.alvaromax.prompt_manager.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alvaromax.prompt_manager.domain.ContextDoc;
import com.alvaromax.prompt_manager.repository.ContextDocRepository;
import com.alvaromax.prompt_manager.repository.StylePresetRepository;
import com.alvaromax.prompt_manager.repository.TemplateRepository;
import com.alvaromax.prompt_manager.service.MarkdownService;
import com.alvaromax.prompt_manager.service.RenderService;
import com.alvaromax.prompt_manager.web.dto.RenderRequest;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/montador")
public class MontadorController {

    private final TemplateRepository templateRepository;
    private final ContextDocRepository contextDocRepository;
    private final StylePresetRepository stylePresetRepository;

    private final RenderService renderService;
    private final MarkdownService markdownService;


    public MontadorController(TemplateRepository templateRepository, ContextDocRepository contextDocRepository,
            StylePresetRepository stylePresetRepository, RenderService renderService, MarkdownService markdownService) {
        this.templateRepository = templateRepository;
        this.contextDocRepository = contextDocRepository;
        this.stylePresetRepository = stylePresetRepository;
        this.renderService = renderService;
        this.markdownService = markdownService;
    }


    @GetMapping
    public String page (Model model) {

        model.addAttribute("templates", templateRepository.findAll());
        model.addAttribute("contexts", contextDocRepository.findAll());
        model.addAttribute("styles", stylePresetRepository.findAll());
        model.addAttribute("req", new RenderRequest());

        return "montador/index";
    }
    

    @PostMapping("/preview")

    public String preview (@ModelAttribute("req") RenderRequest req, Model model) {

        var t = templateRepository.findById(req.getTemplateId()).orElseThrow();
        var selectedContexts = contextDocRepository.findAllById(req.getContextIds());
        var style = req.getStyleId() == null ? null : stylePresetRepository.findById(req.getStyleId()).orElse(null);

        // 1) Montar el markdown total (template + contextos + estilo + extras)
        var assembledMd = renderService.assembleMarkdown(
                t.getBodyMarkdown(),
                selectedContexts.stream().map(ContextDoc::getBodyMarkdown).toList(),
                style != null ? style.getBodyMarkdown() : null,
                req.getExtrasMarkdown());

        // 2) Render Mustache con variables (controla secciones {{#var}})
        var renderedMd = renderService.renderMustache(assembledMd, req.getVariables());

        model.addAttribute("renderedMd", renderedMd);
        model.addAttribute("renderedHtml", markdownService.toHtml(renderedMd));
        model.addAttribute("req", req);
        model.addAttribute("templates", templateRepository.findAll());
        model.addAttribute("contexts", contextDocRepository.findAll());
        model.addAttribute("styles", stylePresetRepository.findAll());
        model.addAttribute("sensitive", selectedContexts.stream().anyMatch(ContextDoc::isSensitive));
        return "montador/index";
    }
    
}
