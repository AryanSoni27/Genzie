package com.genzie.genzie_backend.repositories;

import com.genzie.genzie_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom queries here if needed
}
