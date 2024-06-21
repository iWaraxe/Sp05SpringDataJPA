package com.coherentsolutions.spring.school.section21jpa;

import com.github.javafaker.Faker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpaHibernateExampleApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Faker faker = new Faker();


        UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setName(faker.name().name());
        user.setEmail(faker.internet().emailAddress());

        // Create user
        userService.createUser(user);

        // Read user
        System.out.println("User created with id: " + user.getId());
        User retrievedUser = userService.getUserById(user.getId());
        if (retrievedUser != null) {
            System.out.println("Retrieved User: " + retrievedUser.getName());
        } else {
            System.out.println("No user found with ID " + user.getId());
        }

        // Update user email
        retrievedUser.setEmail("new.email@example.com");
        userService.updateUser(retrievedUser);

        // Delete user
        //userService.deleteUser(retrievedUser.getId());

        // Fetch all users
        for (User u : userService.getAllUsers()) {
            System.out.println("User ID: " + u.getId() + ", Name: " + u.getName() + ", Email: " + u.getEmail());
        }
    }
}
