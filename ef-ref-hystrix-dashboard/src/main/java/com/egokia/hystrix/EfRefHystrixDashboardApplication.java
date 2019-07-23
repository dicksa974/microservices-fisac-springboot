package com.egokia.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableEurekaClient
@EnableHystrixDashboard
@SpringBootApplication
public class EfRefHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfRefHystrixDashboardApplication.class, args);
    }

}
