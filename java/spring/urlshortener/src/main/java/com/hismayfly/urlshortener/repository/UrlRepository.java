package com.hismayfly.urlshortener.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UrlRepository {

    private final EntityManager em;

    public UrlRepository(EntityManager em) {
        this.em = em;
    }

    public String find(String urlKey) {
        // TODO: implement actual logic
        return "testing-" + urlKey;
    }

    public void save(String url) {

    }
}
