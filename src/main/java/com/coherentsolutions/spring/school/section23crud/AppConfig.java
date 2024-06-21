package com.coherentsolutions.spring.school.section23crud;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Detailed exploration of CRUD operations and custom query methods using Spring Data JPA.
 */

@Configuration
@ComponentScan(basePackages = "com.coherentsolutions.spring.school.section23crud")
@EnableJpaRepositories(basePackages = "com.coherentsolutions.spring.school.section23crud")
@Import(DataSourceConfig.class)
public class AppConfig {
}
