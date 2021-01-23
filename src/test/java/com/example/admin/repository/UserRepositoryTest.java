package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

    public void update() {

    }

    public void delete() {

    }

}
