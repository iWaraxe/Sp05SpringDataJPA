package com.coherentsolutions.spring.school.section12orm;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void createUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public User getUserById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    public void updateUserEmail(int id, String newEmail) {
        User user = getUserById(id);
        if (user != null) {
            user.setEmail(newEmail);
            sessionFactory.getCurrentSession().update(user);
        }
    }

    public void deleteUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
