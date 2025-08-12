package com.alvaromax.prompt_manager.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@Service
public class RenderService {

    private MustacheFactory mf = new DefaultMustacheFactory();

    public String renderMustache(String template, Map<String, Object> data) {
        Mustache m = mf.compile(new StringReader(template), "tmpl");
        var w = new StringWriter();
        m.execute(w, data);
        return cleanup(w.toString());
    }

    public String assembleMarkdown(String templateMd,
            List<String> contextMds,
            String styleMd,
            String extrasMd) {

        var sb = new StringBuilder();
        sb.append(templateMd);
        if (!contextMds.isEmpty()) {
            sb.append("\n\n---\n\n");
            contextMds.forEach(md -> sb.append(md).append("\n\n"));
        }
        if (styleMd != null && !styleMd.isBlank()) {
            sb.append("\n\n---\n\n").append(styleMd);
        }
        if (extrasMd != null && !extrasMd.isBlank()) {
            sb.append("\n\n---\n\n").append(extrasMd);
        }
        return cleanup(sb.toString());
    }

    private String cleanup(String s) {
        return s.replaceAll("[ \\t]+\\n", "\n")
                .replaceAll("\\n{3,}", "\n\n")
                .trim();
    }
}