package com.dehu.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConfigApplication.class, args);

        // 持续监听并获取配置文件中的信息
        while (true) {
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            String userSex = applicationContext.getEnvironment().getProperty("user.sex");
            String userEmail = applicationContext.getEnvironment().getProperty("user.email");
            String config = applicationContext.getEnvironment().getProperty("user.config");
            System.err.println("user name :" + userName + "; age: " + userAge + "; sex: " + userSex + "; email: " + userEmail + ";config:" + config);
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
