package com.smorari.demourlshortener.repositories;

import com.smorari.demourlshortener.domains.UrlDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlDomain, Long> {

    @Query("select u from UrlDomain u where u.longUrl=?1")
    Optional<UrlDomain> findByLongUrl(String longUrl);

    @Query("select u from UrlDomain u where u.shortUrl=?1")
    Optional<UrlDomain> findOriginalUrlByShortUrl(String shortUrl);
}
