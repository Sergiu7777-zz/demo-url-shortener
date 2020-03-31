package com.smorari.demourlshortener.services;

import com.smorari.demourlshortener.domains.UrlDomain;
import com.smorari.demourlshortener.repositories.UrlRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public void saveLongURL(UrlDomain urlDomain) {
        if (!urlRepository.findByLongUrl(urlDomain.getLongUrl()).isPresent())
            urlRepository.save(urlDomain);

        encodeURL(urlDomain.getLongUrl());
    }

    public String encodeURL(String longUrl) {
        UrlDomain existingUrl = urlRepository.findByLongUrl(longUrl).orElse(new UrlDomain());
        if (existingUrl.getShortUrl() != null) {
            return existingUrl.getShortUrl();
        } else {
            return RandomStringUtils.randomAlphanumeric(7);
        }
    }

    public String redirectToOriginalUrl(String shortUrl) {
        Optional<UrlDomain> optionalURLDomain = urlRepository.findOriginalUrlByShortUrl(shortUrl);
        return optionalURLDomain.map(UrlDomain::getLongUrl).orElse("NOT_FOUND");
    }
}
