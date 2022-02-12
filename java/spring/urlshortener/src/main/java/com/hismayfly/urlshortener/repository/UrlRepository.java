package com.hismayfly.urlshortener.repository;

import com.hismayfly.urlshortener.domain.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
@RequiredArgsConstructor
public class UrlRepository {

    private final EntityManager em;

    public String findByUuid(String urlKey) {
        TypedQuery<String> query = em.createQuery(
                "SELECT u.originalUrl FROM Url u JOIN u.huid h WHERE h.uuid= :uuid",
                String.class);
        return query.setParameter("uuid", urlKey).getSingleResult();
    }

    public void save(Url url) {
        em.persist(url);
    }
}
