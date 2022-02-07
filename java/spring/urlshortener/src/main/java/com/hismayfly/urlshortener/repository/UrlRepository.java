package com.hismayfly.urlshortener.repository;

import com.hismayfly.urlshortener.domain.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
@RequiredArgsConstructor
public class UrlRepository {

    private final EntityManager em;

    public Url findByUuid(String urlKey) {
        TypedQuery<Url> query = em.createQuery(
                "SELECT u FROM Url u JOIN u.huid h WHERE h.uuid= :uuid",
                Url.class);
        return query.setParameter("uuid", urlKey).getSingleResult();
    }

    public void save(Url url) {
        em.persist(url);
    }
}
