package com.example.gccoffee.controller;

import com.example.gccoffee.model.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    private final String email;
    private final String address;
    private final String postcode;
    private final List<OrderItem> orderItems;
}
