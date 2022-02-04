package com.hismayfly.urlshortener.service;

import com.hismayfly.urlshortener.domain.Url;
import com.hismayfly.urlshortener.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public String find(String urlKey) {
        return urlRepository.find(urlKey);
    }

    public void pair(String url, String shortenedUrl) {
        urlRepository.save(url);
    }
}
