package com.hismayfly.urlshortener.repository;

import com.hismayfly.urlshortener.domain.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class UrlRepository {

    private final EntityManager em;

    public Url find(String urlKey) {
        return em.find(Url.class, urlKey);
    }

    public void save(Url url) {
        em.persist(url);
    }
}
