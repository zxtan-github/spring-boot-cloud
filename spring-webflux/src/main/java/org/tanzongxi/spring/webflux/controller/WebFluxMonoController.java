package org.tanzongxi.spring.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/mono/")
public class WebFluxMonoController {

    @GetMapping("helloWorld")
    public Mono<String> helloWorld() {
        return Mono.just("helloWorld");
    }

    @GetMapping("helloWorld2")
    public Mono<String> helloWorld2() {
        return Mono.create(e -> {
            System.out.println("e ---> " + e);
            System.out.println("---> helloWorld2 ..");
        });
    }

    @GetMapping("helloWorld3")
    public Mono<String> helloWorld3() {
        final String uuid = UUID.randomUUID().toString();
        System.out.println(Thread.currentThread().getName() + " " + uuid + " " + new Date() + " -> start");
        Mono<String> h = Mono.fromSupplier(() -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + uuid + " " + new Date() + " -> Supplier");
                    return "helloWorld3";
                }
        );
        System.out.println(Thread.currentThread().getName() + " " + uuid + " " + new Date() + " -> end");
        return h;
    }


    @GetMapping("helloWorld4")
    public Mono<String> helloWorld4() {
        System.out.println(Thread.currentThread().getName() + " " + new Date() + " -> start");
        Mono<String> h = Mono.fromSupplier(() -> {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + new Date() + " -> Supplier");
                    return "helloWorld4";
                }
        );

        System.out.println(Thread.currentThread().getName() + " " + new Date() + " -> end");
        return h;
    }
}
