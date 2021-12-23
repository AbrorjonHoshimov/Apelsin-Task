package com.example.test.repository;

import com.example.test.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByName(String name);
    @Query(value = "select det.quantity,pr.name,pr.price,pr.price*det.quantity as sum  from orders o natural join detail det natural join product pr where o.customer_id=:customer_id",nativeQuery = true)
    List<?> getAllInfo(@Param("customer_id") Integer customer_id);


    @Query(value = "select pr.name from orders inner join detail det on orders.id = det.order_id inner join product pr on d.product_id = pr.id where det.quantity>=10",nativeQuery = true)
    List<?> getProductMoreThanTen();

    @Query(value = "select pr.name,pr.price from product pr natural join detail det where det.quantity>=8",nativeQuery = true)
    List<?>getAllByQuantityEight();

}
