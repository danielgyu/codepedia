package com.hismayfly.experiments.webclient;

import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;
import reactor.netty.http.client.HttpClient;


@Component
public class MyHttpClient {
    final WebClient webClient;

    public MyHttpClient() {
        HttpClient httpClient = HttpClient.create();
        ClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);
        this.webClient = WebClient.builder()
                .uriBuilderFactory(new DefaultUriBuilderFactory("http://localhost:8000"))
                .clientConnector(connector)
                .build();
    }
}
