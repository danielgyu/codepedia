package com.hismayfly.urlshortener.controller;

import com.hismayfly.urlshortener.domain.Huid;
import com.hismayfly.urlshortener.domain.Url;
import com.hismayfly.urlshortener.service.KeyGeneratorService;
import com.hismayfly.urlshortener.service.UrlService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UrlController {

    private final UrlService urlService;
    private final KeyGeneratorService keyGeneratorService;

    @GetMapping("/{key}")
    public RedirectOriginalUrlResponse getOriginalUrl(@PathVariable String key) {
        Url url = urlService.findByUuid(key);
        // TODO redirect
        return new RedirectOriginalUrlResponse(url.getOriginalUrl());
    }

    @PostMapping("/url")
    public CreateShortenedUrlResponse createShortenedUrl(@RequestBody CreateShortenedUrlRequest request) {
        Huid huid = keyGeneratorService.generateKey();

        Url url = new Url();
        url.setOriginalUrl(request.getOriginalUrl());
        url.setUserId(request.getUserId());
        url.setHuid(huid);

        urlService.pair(url);
        return new CreateShortenedUrlResponse(huid.getUuid());
    }

    @Data
    static class RedirectOriginalUrlResponse {
        private String originalUrl;

        public RedirectOriginalUrlResponse(String originalUrl) {
            this.originalUrl = originalUrl;
        }
    }

    @Data
    static class CreateShortenedUrlRequest {
        private String originalUrl;
        private int userId; // TODO substitute with spring security
    }

    @Data
    static class CreateShortenedUrlResponse {
        private String shortenedUrl;

        public CreateShortenedUrlResponse(String url) {
            this.shortenedUrl = url;
        }
    }
}
