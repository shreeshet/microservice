package com.simply.tp.sakilaflix.userservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;


/**
 * Created by shreeharshashet on 2/6/18.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSpringBootMetricsCollector
@EnablePrometheusEndpoint
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
