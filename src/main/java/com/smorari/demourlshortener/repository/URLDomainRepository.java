package com.smorari.demourlshortener.repository;

import com.smorari.demourlshortener.domain.URLDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLDomainRepository extends JpaRepository<URLDomain, Long> {
}
