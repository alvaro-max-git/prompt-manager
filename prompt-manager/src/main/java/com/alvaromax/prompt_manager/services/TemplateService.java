package com.alvaromax.prompt_manager.services;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaromax.prompt_manager.repositories.TemplateRepository;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository repo;

    private MustacheFactory mf = new DefaultMustacheFactory();

    public String render (String body, Map<String,Object> data) {
        
        Mustache m = mf.compile(new StringReader(body), "tmpl");
        StringWriter w = new StringWriter();
        m.execute(w, data); // data puede incluir booleanos para secciones {{#var}}
        return w.toString();
    }
}


