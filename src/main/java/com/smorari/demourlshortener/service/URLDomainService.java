package com.smorari.demourlshortener.service;

import com.smorari.demourlshortener.domain.URLDomain;
import com.smorari.demourlshortener.repository.URLDomainRepository;
import com.smorari.demourlshortener.util.Base62;
import org.springframework.stereotype.Service;

@Service
public class URLDomainService {

    private Base62 base62 = new Base62();

    private final URLDomainRepository urlDomainRepository;

    public URLDomainService(URLDomainRepository urlDomainRepository) {
        this.urlDomainRepository = urlDomainRepository;
    }

    public String saveLongURL(String longURL) {
        URLDomain urlDomain = new URLDomain();
        urlDomain.setLongUrl(longURL);
        urlDomainRepository.save(urlDomain);

        return "localhost:8080/" + encodeURL(urlDomain.getId());
    }

    private String encodeURL(long longUrlId) {
        return base62.toBase62(longUrlId);
    }
}
