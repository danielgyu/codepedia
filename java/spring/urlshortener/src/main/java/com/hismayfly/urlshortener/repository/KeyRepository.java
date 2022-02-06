package com.hismayfly.urlshortener.repository;

import com.hismayfly.urlshortener.domain.Huid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class KeyRepository {

    private final EntityManager em;

    public Boolean contains(Huid huid) {
        return em.contains(huid);
    }

    public void save(Huid huid) {
        em.persist(huid);
    }
}
