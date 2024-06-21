package com.coherentsolutions.spring.school.section22entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here

    // CrudRepository<User,Long> : save(), findById(id), findAll(), deleteById(id)
    // JpaRepository<User,Long> :findAll(Pageable pageable), flush()
}
