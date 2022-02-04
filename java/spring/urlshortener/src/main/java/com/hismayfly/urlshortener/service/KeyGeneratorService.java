package com.hismayfly.urlshortener.service;

import com.hismayfly.urlshortener.domain.HUID;
import com.hismayfly.urlshortener.repository.KeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KeyGeneratorService {

    private final KeyRepository keyRepository;

    public String generateKey() {
        String uuid = UUID.randomUUID().toString().substring(0, 8);
        HUID huid = new HUID();
        huid.setUuid(uuid);

        while (keyRepository.contains(huid)) {
            uuid = UUID.randomUUID().toString().substring(0, 8);
            huid.setUuid(uuid);
        }

        keyRepository.save(huid);
        return huid.getUuid();
    }
}
