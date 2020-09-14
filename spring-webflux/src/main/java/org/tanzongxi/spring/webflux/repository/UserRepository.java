package org.tanzongxi.spring.webflux.repository;

import org.springframework.stereotype.Repository;
import org.tanzongxi.spring.webflux.entity.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    //模拟数据库存储
    private static Map<Integer, User> userMap = new HashMap<>();

    //初始化仓储数据
    static {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("用户1");
        userMap.put(1, user1);
        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("用户2");
        userMap.put(2, user2);
    }

    public Map<Integer, User> getUserByUserId() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printlnThread("调用getUserByUserId");
        return userMap;
    }


    public Map<Integer, User> getUsers() {
        printlnThread("调用getUsers");
        return userMap;
    }

    /**
     * 打印当前线程
     *
     * @param object
     */
    private void printlnThread(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " -> " + object);
    }
}