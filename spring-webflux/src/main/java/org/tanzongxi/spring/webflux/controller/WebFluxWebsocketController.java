package org.tanzongxi.spring.webflux.controller;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanzongxi.spring.webflux.entity.User;
import org.tanzongxi.spring.webflux.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Map;
import java.util.UUID;

/**
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/8/31 10:21
 */
@RestController
@RequestMapping("/stream/")
public class WebFluxWebsocketController {

    @GetMapping("list")
    public Flux<String> streamList() {
        return Flux.interval(Duration.ofSeconds(1)).map(e -> e + ",");
    }


    @GetMapping("event")
    public Flux<ServerSentEvent<String>> streamEvent() {
        Flux<Long> flux = Flux.interval(Duration.ofSeconds(1));
        Flux<ServerSentEvent<String>> eventFlux = flux.map(e ->
                ServerSentEvent.<String>builder()
                        .id(UUID.randomUUID().toString())
                        .event("ping event")
                        .data(e.toString())
                        .build()
        );
        return eventFlux;
    }


    @GetMapping("event2")
    public Flux<ServerSentEvent<String>> streamEvent2() {
        return Flux.interval(Duration.ofSeconds(1)).map(e ->
                ServerSentEvent.<String>builder()
                        .id(UUID.randomUUID().toString())
                        .event("ping event")
                        .data(e.toString())
                        .build()
        );
    }

}
