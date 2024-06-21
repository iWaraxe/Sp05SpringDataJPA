package com.coherentsolutions.spring.school.section22entities;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Detailed definition of JPA entities and various Spring Data JPA repository interfaces.
 */

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section22entities")
@EnableJpaRepositories(basePackages = "com.coherentsolutions.spring.school.section22entities")
@Import(DataSourceConfig.class)
public class AppConfig {
}
