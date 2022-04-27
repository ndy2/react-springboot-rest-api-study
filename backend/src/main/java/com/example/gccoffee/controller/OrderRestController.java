package com.example.gccoffee.controller;

import com.example.gccoffee.model.Email;
import com.example.gccoffee.model.Order;
import com.example.gccoffee.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderRestController {

    private final OrderService orderService;

    @PostMapping("/orders")
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {

        return orderService.createOrder(
                new Email(orderRequest.getEmail()),
                orderRequest.getAddress(),
                orderRequest.getPostcode(),
                orderRequest.getOrderItems()
        );
    }

}
