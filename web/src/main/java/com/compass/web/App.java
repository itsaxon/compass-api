package com.compass.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 应用程序
 *
 * @author itsaxon
 * @date 2022/07/28
 */
@SpringBootApplication(scanBasePackages = "com.compass")
public class App {

    public static void main(String[] args) {
        System.out.println("App starting -------------------------");
        SpringApplication.run(App.class, args);
        System.out.println("App started -------------------------");
    }

}
