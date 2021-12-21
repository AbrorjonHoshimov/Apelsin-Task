package com.example.test.repository;

import com.example.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Product,Integer> {

}
