package com.aeon.librarysystem.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Value("${api.version}")
    private String version;

    @Value("${api.author}")
    private String author;

    @Value("${api.message}")
    private String message;

    @Value("${api.description}")
    private String description;

    @GetMapping("/")
    public Map<String, String> getApiInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("message", message);
        info.put("version", version);
        info.put("description", description);
        info.put("author", author);
        return info;
    }
}