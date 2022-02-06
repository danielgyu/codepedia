package com.hismayfly.urlshortener.service;

import com.hismayfly.urlshortener.domain.Huid;
import com.hismayfly.urlshortener.repository.KeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KeyGeneratorService {

    private final KeyRepository keyRepository;

    @Transactional
    public Huid generateKey() {
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        Huid huid = new Huid();
        huid.setUuid(uuid);

        while (checkDuplicate(huid)) {
            uuid = UUID.randomUUID().toString().substring(0, 8);
            huid.setUuid(uuid);
        }

        keyRepository.save(huid);
        return huid;
    }

    public boolean checkDuplicate(Huid huid) {
        return keyRepository.contains(huid);
    }
}
