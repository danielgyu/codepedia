package com.hismayfly.urlshortener.controller;

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
        String originalurl = urlService.find(key);
        // TODO redirect later
        return new RedirectOriginalUrlResponse(originalurl);
    }

    @PostMapping("/url")
    public CreateShortenedUrlResponse createShortenedUrl(@RequestBody Url url) {
        String shortenedUrl = keyGeneratorService.generateKey();
        urlService.pair(url.getOriginalurl(), shortenedUrl);
        return new CreateShortenedUrlResponse(shortenedUrl);
    }

    @Data
    static class RedirectOriginalUrlResponse {
        private String originalUrl;

        public RedirectOriginalUrlResponse(String originalUrl) {
            this.originalUrl = originalUrl;
        }
    }

    @Data
    static class CreateShortenedUrlResponse {
        private String shortenedUrl;

        public CreateShortenedUrlResponse(String shortenedUrl) {
            this.shortenedUrl = shortenedUrl;
        }
    }
}
