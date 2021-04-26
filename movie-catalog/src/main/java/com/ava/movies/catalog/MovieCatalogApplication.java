package com.ava.movies.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//it is optional to put @EnableEurekaClient as spring boot auto detect itO
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class MovieCatalogApplication {

    public static void main(String[] args) {

        SpringApplication.run(MovieCatalogApplication.class, args);

    }


}
