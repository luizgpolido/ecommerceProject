package com.luizpolido.ecommerce.controllers;

import com.luizpolido.ecommerce.dto.ProductDTO;
import com.luizpolido.ecommerce.entities.Product;
import com.luizpolido.ecommerce.repositories.ProductRepository;
import com.luizpolido.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"/{id}"})
    public ProductDTO findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping
    public Page<ProductDTO> findAll (Pageable pageable){
        return productService.findAll(pageable);
    }
}
