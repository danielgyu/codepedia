package com.hismayfly.experiments.webclient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RestController
@RequiredArgsConstructor
public class MyEndpoint {
    final MyHttpClient client;

    @GetMapping("/event")
    public void relayEvent() {
        System.out.println("Thread.currentThread().getId() = " + Thread.currentThread().getId());

        MyEvent eventMono = new MyEvent("search");
        Mono <MyResponseItem> response = client.webClient.post()
                .uri("/adyo")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(eventMono), MyEvent.class)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, this::handleErrors)
                .onStatus(HttpStatusCode::is5xxServerError, this::handleErrors)
                .bodyToMono(MyResponseItem.class);

        System.out.println("response = " + response);
        response.subscribe(System.out::println);
    }

    private Mono<? extends Throwable> handleErrors(ClientResponse clientResponse) {
        System.out.println("clientResponse = " + clientResponse);
        return Mono.error(new Exception("error"));
    }

    record MyEvent(String eventType) {}

    record MyResponseItem(String id) {}
}
