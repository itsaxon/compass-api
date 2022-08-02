package com.compass.web;

import cn.hutool.core.collection.CollUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

/**
 * 应用启动程序
 *
 * @author itsaxon
 * @date 2022/07/28
 */
@SpringBootApplication(scanBasePackages = "com.compass")
public class App {

    public static void main(String[] args) {
        System.out.print("App starting -------------------------");
        SpringApplication springApplication = new SpringApplication();
        ArrayList<Class<?>> sources = CollUtil.newArrayList(App.class);
        springApplication.addPrimarySources(sources);
        // TODO: 2022/8/1 添加启动项目监听
        springApplication.run(args);
        System.out.println("App started -------------------------");
    }

}
