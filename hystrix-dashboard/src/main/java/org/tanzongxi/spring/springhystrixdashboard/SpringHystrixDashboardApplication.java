package org.tanzongxi.spring.springhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringCloudApplication
public class SpringHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHystrixDashboardApplication.class, args);
    }
}
