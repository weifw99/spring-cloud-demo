package com.mtime.spring.cloud.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Jason on 5/4/16.
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServiceApplication.class).web(true).run(args);
    }
}
