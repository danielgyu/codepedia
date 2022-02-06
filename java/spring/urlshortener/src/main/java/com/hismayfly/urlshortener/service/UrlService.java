package com.hismayfly.urlshortener.service;

import com.hismayfly.urlshortener.domain.Url;
import com.hismayfly.urlshortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public Url find(String urlKey) {
        return urlRepository.find(urlKey);
    }

    @Transactional
    public void pair(Url url) {
        urlRepository.save(url);
    }
}
