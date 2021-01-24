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
    @Transactional
    public void create() {
        String account = "test01";
        String password = "test01";
        String status = "REGISTERED";
        String email = "test01@test.test";
        String phoneNumber = "010-0000-0000";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assertions.assertNotNull(newUser);
    }

    @Test
    public void read() {
        String phoneNumber = "010-0000-0000";

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);
        Assertions.assertNotNull(user);
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
