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
//    @Transactional
    public void create() {
        String account = "test03";
        String password = "test03";
        String status = "REGISTERED";
        String email = "test03@test.test";
        String phoneNumber = "010-0000-1111";
        LocalDateTime registeredAt = LocalDateTime.now();
//        LocalDateTime createdAt = LocalDateTime.now();
//        String createdBy = "AdminServer";

//        User user = new User();
//        user.setAccount(account);
//        user.setPassword(password);
//        user.setStatus(status);
//        user.setEmail(email);
//        user.setPhoneNumber(phoneNumber);
//        user.setRegisteredAt(registeredAt);

        // BUILDER
        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .phoneNumber(phoneNumber)
                .registeredAt(registeredAt)
                .build();

//        User newUser = userRepository.save(user);

//        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        String phoneNumber = "010-0000-0000";

        Optional<User> user = userRepository.findFirstByPhoneNumberOrderByIdDesc(phoneNumber);

//        user.ifPresent(u -> {
//            u.setStatus("READING");
//        });

        user.ifPresent(u -> {
            u.getOrderGroupList().forEach(orderGroup -> {
                System.out.println("=============================================");
                System.out.println("Price: " + orderGroup.getTotalPrice());
                System.out.println("Quantity: " + orderGroup.getTotalQuantity());
                System.out.println("Address" + orderGroup.getRevAddress());
                System.out.println("Name: " + orderGroup.getRevName());
                System.out.println("=============================================");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("Partner: " + orderDetail.getItem().getPartner().getName());
                    System.out.println("Category: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("Item Name: " + orderDetail.getItem().getName());
                    System.out.println("CS: " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("Status: " + orderDetail.getStatus());
                    System.out.println("Expected to get: " + orderDetail.getArrivalDate());
                    System.out.println("=============================================");
                });
            });
        });

        Assertions.assertTrue(user.isPresent());
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
