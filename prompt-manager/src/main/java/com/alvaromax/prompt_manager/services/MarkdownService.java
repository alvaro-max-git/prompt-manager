package com.alvaromax.prompt_manager.services;

import org.springframework.stereotype.Service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;

@Service
public class MarkdownService {

    public String toHtml (String md) {
        return HtmlRenderer.builder()
            .build()
            .render( Parser.builder().build().parse(md));
    }

}
