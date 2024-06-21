package com.coherentsolutions.spring.school.section11jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * JDBC Basics
 */
public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);

        UserDao userDao = context.getBean(UserDao.class);

        User newUser = new User();
        newUser.setName("SimpleName");
        newUser.setEmail("email@email.com");
        userDao.createUser(newUser);

        List<User> users = userDao.getAllUsers();

        for (User user : users) {
            System.out.println("User ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
        }

    }
}
