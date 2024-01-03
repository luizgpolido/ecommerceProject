package com.luizpolido.ecommerce.controllers;

import com.luizpolido.ecommerce.entities.Product;
import com.luizpolido.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String teste(){
        Optional<Product> product = productRepository.findById(1L);
        Product produto = product.get();
        return produto.getName();
    }
}
