package com.example.test.controller;

import com.example.test.entity.Order;
import com.example.test.payload.ApiResponse;
import com.example.test.payload.OrderDTO;
import com.example.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/add")
    public HttpEntity<?> addOrder(@RequestBody OrderDTO orderDto) {
        ApiResponse apiResponse = orderService.addOrder(orderDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping("/list")
    public HttpEntity<?> getAll() {
        List<Order> all = orderService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable int id) {
        ApiResponse one = orderService.getOne(id);
        return ResponseEntity.status(one.isSuccess() ? 200 : 409).body(one);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteOrder(@PathVariable int id) {
        ApiResponse apiResponse = orderService.deleteOrder(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 409).body(apiResponse);
    }

    @GetMapping("/getOrder")
    public HttpEntity<?> getOrder(@RequestParam int id) {
        List<Order> order = orderService.getOrder(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/getLastOrders")
    public HttpEntity<?> getLastOrders() {
        ApiResponse apiResponse = orderService.lastOrders();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/getOrderWIthOutDetails")
    public HttpEntity<?> getOrderWithOutDetail() {
        ApiResponse apiResponse = orderService.getOrdersWithoutDetail();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/getDetailOrder")
    public HttpEntity<?> getDetails(@RequestParam int id) {
        ApiResponse apiResponse = orderService.getDetailOrder(id);
        return ResponseEntity.ok(apiResponse);
    }

}
