package com.hismayfly.urlshortener.repository;

import com.hismayfly.urlshortener.domain.HUID;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class KeyRepository {

    private final EntityManager em;

    public KeyRepository(EntityManager em) {
        this.em = em;
    }

    public Boolean contains(HUID huid) {
        return em.contains(huid);
    }

    public void save(HUID huid) {
        em.persist(huid);
    }
}
