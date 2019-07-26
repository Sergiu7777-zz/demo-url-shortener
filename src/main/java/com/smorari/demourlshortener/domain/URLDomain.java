package com.smorari.demourlshortener.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;

@Data
@Entity
public class URLDomain {

    @Id
    private Long id;
    private String longUrl;
}
