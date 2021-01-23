package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired // DI
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("test03");
        user.setEmail("test03@test.test");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test03");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(foundUser -> {
            System.out.println("user: " + foundUser);
            System.out.println("email: " + foundUser.getEmail());
        });
    }

    @Test
    @Transactional
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(foundUser -> {
            System.out.println("found user: " + foundUser);

            foundUser.setAccount("updated");
            foundUser.setUpdatedAt(LocalDateTime.now());
            foundUser.setUpdatedBy(foundUser.getAccount());

            User newUser = userRepository.save(foundUser);
            System.out.println("updated user: " + newUser);
        });
    }

    @Test
    @Transactional
    public void delete() {

        Long id = 3L;

        Optional<User> user = userRepository.findById(id);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(foundUser -> {
            userRepository.delete(foundUser);
            System.out.println("deleted: " + foundUser);
        });

        Optional<User> deletedUser = userRepository.findById(id);

        Assertions.assertFalse(deletedUser.isPresent());
    }

}
