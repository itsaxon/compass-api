package com.compass.web;

import cn.hutool.core.collection.CollUtil;
import org.apache.commons.compress.utils.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

/**
 * 应用程序
 *
 * @author itsaxon
 * @date 2022/07/28
 */
@SpringBootApplication(scanBasePackages = "com.compass")
public class App {

    public static void main(String[] args) {
//        System.out.println("App starting -------------------------");
//        SpringApplication.run(App.class, args);
//        System.out.println("App started -------------------------");

        System.out.println("App starting -------------------------");
        SpringApplication springApplication = new SpringApplication();
        ArrayList<Class<?>> sources = CollUtil.newArrayList(App.class);
        springApplication.addPrimarySources(sources);

        springApplication.run(args);
        System.out.println("App started -------------------------");

    }

}
