package com.egokia.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@EnableZipkinServer
@EnableEurekaClient
@SpringBootApplication
public class EfRefZipkinServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EfRefZipkinServiceApplication.class, args);
    }

}
