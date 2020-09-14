package org.tanzongxi.spring.webflux.reactor;

import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class FluxMonoTest01 {

    Logger log = LoggerFactory.getLogger(FluxMonoTest01.class);

    @Test
    public void createFlux() throws InterruptedException, IOException {

        // 直接创建
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);
        Flux<String> stringFlux = Flux.just("abc", "def");

        // 数组创建
        String[] strs = {"hello", "world", "array"};
        Flux<String> arrayFlux = Flux.fromArray(strs);
        // List创建
        Flux<String> listFlux = Flux.fromIterable(Arrays.asList(strs));

        // 范围创建，第一个参数：start起始值，第二个参数：count数量
        Flux<String> rangeFlux = Flux.range(1001, 5).map(e -> String.valueOf(e));

        // 时间间隔创建
        Flux<String> intervalFlux = Flux.interval(Duration.ofSeconds(3), Duration.ofSeconds(1)).map(e -> String.valueOf(e));

        // Flux创建
        Flux<String> fluxToFlux = Flux.from(rangeFlux);

        integerFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        stringFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        arrayFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        listFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        rangeFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        intervalFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        fluxToFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));

        TimeUnit.SECONDS.sleep(10);
    }


    @Test
    public void createMono() throws InterruptedException, IOException {
        // 直接创建
        Mono<String> stringMono = Mono.just("hello");
        // callable创建
        Mono<String> callableMono = Mono.fromCallable(() -> "fromCallable");
        // supplier创建
        Mono<String> supplierMono = Mono.fromSupplier(() -> "fromSupplier");
        // Mono创建
        Mono<String> monoToMono = Mono.from(stringMono);
        // Flux创建，只会取第一个
        Mono<Integer> fluxToMono = Mono.from(Flux.range(1, 5));

        stringMono.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        callableMono.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        supplierMono.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        monoToMono.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        fluxToMono.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));

        TimeUnit.SECONDS.sleep(10);

    }

    @Test
    public void subscribe() {
        Flux<String> stringFlux = Flux.just("abc", "def", "hij");
        stringFlux.subscribe(
                val -> System.out.println(Thread.currentThread().getName() + "->" + val),
                error -> System.out.println(Thread.currentThread().getName() + "->" + "error"),
                () -> System.out.println(Thread.currentThread().getName() + "->" + "finish"),
                subscription -> subscription.request(2));

        stringFlux.subscribe(new Subscriber<String>() {
            // 获取多少个元素
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(2);
            }

            // 处理每个元素
            @Override
            public void onNext(String val) {
                System.out.println(Thread.currentThread().getName() + "->" + val);
            }

            // 处理发生错误时
            @Override
            public void onError(Throwable throwable) {
                System.out.println(Thread.currentThread().getName() + "->" + "error");
            }

            // 处理完成时
            @Override
            public void onComplete() {
                System.out.println(Thread.currentThread().getName() + "->" + "finish");
            }
        });
    }


    @Test
    public void createFluxFilterAndMap() throws InterruptedException, IOException {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4, 5);
        Flux<String> integerFilterFlux = integerFlux.filter(e -> e % 2 == 0).filter(e -> e > 2).map(e -> String.valueOf(e));
        integerFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));
        integerFilterFlux.subscribe(e -> System.out.println(Thread.currentThread().getName() + "->" + e));


        integerFlux.window(2).flatMap(flux -> flux);
        integerFlux.parallel()
                .runOn(Schedulers.parallel());
    }


    @Test
    public void flatMap() {
        Flux<String> stringFlux1 = Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i");
        //嵌套Flux
        Flux<Flux<String>> stringFlux2 = stringFlux1.window(3);
        stringFlux2.collectMap(flux1 -> flux1.map(word -> word.toUpperCase()))
                .subscribe(System.out::print);
        //从嵌套Flux还原字符串Flux
        Flux<String> stringFlux3 = stringFlux2.flatMap(flux1 -> flux1);
        // stringFlux1 等于 stringFlux3
        stringFlux3.subscribe(System.out::print);
    }


}
