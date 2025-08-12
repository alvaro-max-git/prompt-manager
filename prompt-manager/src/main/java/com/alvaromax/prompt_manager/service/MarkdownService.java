package com.alvaromax.prompt_manager.service;

import org.springframework.stereotype.Service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

@Service
public class MarkdownService {

    private final Parser parser = Parser.builder().build();
    private final HtmlRenderer renderer = HtmlRenderer.builder().build();

    public String toHtml (String md) {
        return renderer.render(parser.parse(md == null ? "" : md));
    }
}
