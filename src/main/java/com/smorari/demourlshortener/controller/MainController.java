package com.smorari.demourlshortener.controller;

import com.smorari.demourlshortener.service.URLDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private URLDomainService service;



    @RequestMapping("/")
    public String mainPage() {
        return "main.html";
    }

    @PostMapping("/")
    public String saveLongUrl(String longUrl) {

        return service.saveLongURL(longUrl);
    }
}
