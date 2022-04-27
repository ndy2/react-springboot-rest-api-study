package com.example.gccoffee.service;

import com.example.gccoffee.model.Email;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.model.OrderItem;
import com.example.gccoffee.model.OrderStatus;
import com.example.gccoffee.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order createOrder(Email email, String address, String postcode, List<OrderItem> orderItems) {
        Order order = new Order(UUID.randomUUID(), email, address, postcode, orderItems, OrderStatus.ACCEPTED, LocalDateTime.now(), LocalDateTime.now());
        return orderRepository.insert(order);
    }
}
