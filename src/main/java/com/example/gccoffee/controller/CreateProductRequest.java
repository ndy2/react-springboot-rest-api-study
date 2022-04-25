package com.example.gccoffee.controller;

import com.example.gccoffee.model.Category;
import lombok.Data;

@Data
public class CreateProductRequest {
    private final String productName;
    private final Category category;
    private final long price;
    private final String description;
}
