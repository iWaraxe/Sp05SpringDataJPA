package com.coherentsolutions.spring.school.section12orm;

import com.github.javafaker.Faker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Faker faker = new Faker();

        UserDao userDao = context.getBean(UserDao.class);

        User user = new User();
        user.setName(faker.name().name());
        user.setEmail(faker.internet().emailAddress());

        // Create user
        userDao.createUser(user);

        // Read user
        User retrievedUser = userDao.getUserById(2);
        System.out.println("Retrieved User: " + retrievedUser.getName());

        // Update user email
        userDao.updateUserEmail(1, faker.internet().emailAddress());

        // Delete user
        userDao.deleteUser(1);

        // Fetch all users
        List<User> users = userDao.getAllUsers();
        for (User u : users) {
            System.out.println("User ID: " + u.getId() + ", Name: " + u.getName() + ", Email: " + u.getEmail());
        }
    }
}
