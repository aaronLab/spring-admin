package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.Item;
import com.example.admin.model.entity.OrderDetail;
import com.example.admin.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class UserRepositoryTest extends AdminApplicationTests {

    @Autowired // DI
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("test user");
        user.setEmail("test@test.test");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("test user");

        User newUser = userRepository.save(user);
        System.out.println("newUser: " + newUser);
    }

    @Test
    @Transactional
    public void read() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(foundUser -> {

            foundUser.getOrderDetailList().forEach(orderDetail -> {
                Item item = orderDetail.getItem();
                System.out.println(item);
            });
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
