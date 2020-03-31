package com.smorari.demourlshortener.domains;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class UrlDomain {
    private static final String BASE_URL = "http://localhost:8080/";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String longUrl;
    private String shortUrl;

    public UrlDomain() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String displayShortUrl() {
        return shortUrl == null ? "" : BASE_URL + shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UrlDomain urlDomain = (UrlDomain) o;
        return Objects.equals(id, urlDomain.id) &&
                Objects.equals(longUrl, urlDomain.longUrl) &&
                Objects.equals(shortUrl, urlDomain.shortUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, longUrl, shortUrl);
    }
}
