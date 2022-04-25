package com.example.gccoffee.controller;

import com.example.gccoffee.model.Product;
import com.example.gccoffee.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String productPage(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/new-product")
    public String newProductPage(){
        return "new-product";
    }

    @PostMapping("/products")
    public String newProduct(CreateProductRequest createProductRequest){

        productService.createProduct(
                createProductRequest.getProductName(),
                createProductRequest.getCategory(),
                createProductRequest.getPrice(),
                createProductRequest.getDescription());

        return "redirect:/products";
    }
}
