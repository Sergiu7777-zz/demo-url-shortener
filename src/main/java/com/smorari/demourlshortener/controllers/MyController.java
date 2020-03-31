package com.smorari.demourlshortener.controllers;

import com.smorari.demourlshortener.domains.UrlDomain;
import com.smorari.demourlshortener.services.UrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.URI;

@Controller
public class MyController {

    private final UrlService service;
    UrlDomain domain = new UrlDomain();

    public MyController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/index")
    public String handlePostRequest(String longUrl) {
        domain.setLongUrl(longUrl);
        domain.setShortUrl(service.encodeURL(longUrl));
        service.saveLongURL(domain);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showSubmitForm(Model model) {
        model.addAttribute("urlDomain", domain);
        return "index-view";
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = service.redirectToOriginalUrl(shortUrl);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }
}
