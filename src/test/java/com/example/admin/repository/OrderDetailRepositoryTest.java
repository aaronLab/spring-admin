package com.example.admin.repository;

import com.example.admin.AdminApplicationTests;
import com.example.admin.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public class OrderDetailRepositoryTest extends AdminApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    @Transactional
    public void create() {
        OrderDetail orderDetail = new OrderDetail();

//        orderDetail.setOrderAt(LocalDateTime.now());

//        orderDetail.setItemId(1L);
//        orderDetail.setUserId(1L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);

        Assertions.assertNotNull(newOrderDetail);
    }

    @Test
    public void read() {
        Long orderId = 1L;

        Optional<OrderDetail> order = orderDetailRepository.findById(orderId);

        Assertions.assertTrue(order.isPresent());
    }

}
