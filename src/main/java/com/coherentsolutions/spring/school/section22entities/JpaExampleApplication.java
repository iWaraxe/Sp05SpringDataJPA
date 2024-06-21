package com.coherentsolutions.spring.school.section22entities;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpaExampleApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setName("Jane Doe");
        user.setEmail("jane.doe@example.com");

        // Create user
        userService.createUser(user);

        // Read user
        User retrievedUser = userService.getUserById(user.getId());
        System.out.println("Retrieved User: " + retrievedUser.getName());

        // Update user email
        retrievedUser.setEmail("new.email@example.com");
        userService.updateUser(retrievedUser);
        System.out.println("Updated User: " + retrievedUser.getName() + " with email: " + retrievedUser.getEmail());

        // Delete user
        userService.deleteUser(retrievedUser.getId());
        System.out.println();

        // Fetch all users
        for (User u : userService.getAllUsers()) {
            System.out.println("User ID: " + u.getId() + ", Name: " + u.getName() + ", Email: " + u.getEmail());
        }
    }
}
