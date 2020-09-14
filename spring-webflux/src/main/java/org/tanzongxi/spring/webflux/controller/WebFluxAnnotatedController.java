package org.tanzongxi.spring.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tanzongxi.spring.webflux.entity.User;
import org.tanzongxi.spring.webflux.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Map;
/**
 *
 * @author tanzongxi [tanzongxi@ifunq.com]
 * @date 2020/8/21 17:41
 *
 * https://www.jianshu.com/p/2db1ecacb770
 */
@RestController
@RequestMapping("/annotated/")
public class WebFluxAnnotatedController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询单个用户
     * @param id
     * @return  返回Mono 非阻塞单个结果
     */
    @GetMapping("user/{id}")
    public Mono<User> getUserByUserId(@PathVariable("id") int id) {
        System.out.println(Thread.currentThread().getName() + " start-> " +  new Date());
        Mono<User> user = Mono.just(userRepository.getUserByUserId().get(id));
        System.out.println(Thread.currentThread().getName() + " end-> " +  new Date());
        return user;
    }

    /**
     *
     * @return  返回Flux 非阻塞序列
     */
    @GetMapping("users")
    public Flux<User> getAll() {
        printlnThread("获取HTTP请求");
        //使用lambda表达式
        return Flux.fromStream(userRepository.getUsers().entrySet().stream().map(Map.Entry::getValue));
    }

    /**
     * 打印当前线程
     * @param object
     */
    private void printlnThread(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " -> " + object);
    }
}
