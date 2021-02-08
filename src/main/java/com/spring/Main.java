package com.spring;

import com.spring.config.AppConfig;
import com.spring.model.User;
import com.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        User jhon = new User();
        jhon.setName("Jhon");
        jhon.setLastName("Doe");

        User bob = new User();
        bob.setName("Bob");
        bob.setLastName("Thomson");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.add(jhon);
        userService.add(bob);
        System.out.println(userService.listUsers());
    }
}
