package com.luizpolido.ecommerce.repositories;

import com.luizpolido.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product, Long> {
}
