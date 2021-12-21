package com.example.test.service;

import com.example.test.entity.Customer;
import com.example.test.payload.ApiResponse;
import com.example.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public ApiResponse addCustomer(Customer customerDto) {
        Customer customer =new Customer();
        customer.setName(customerDto.getName());
        customer.setCountry(customerDto.getCountry());
        customer.setAddress(customerDto.getAddress());
        customer.setPhone(customerDto.getPhone());
        customerRepository.save(customer);
        return new ApiResponse("saved",true);
    }

    public ApiResponse editCustomer(int id, Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent())return new ApiResponse("Not Found",false);
        Customer customer1 = optionalCustomer.get();
        customer1.setName(customer.getName());
        customer1.setPhone(customer.getPhone());
        customer1.setAddress(customer.getAddress());
        customer1.setCountry(customer.getCountry());
        customerRepository.save(customer1);
        return new ApiResponse("Edited",true);
    }

    public List<Customer> getAll() {
    return customerRepository.findAll();
    }

    public ApiResponse getOneCustomer(int id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (!optionalCustomer.isPresent())return new ApiResponse("Not Found",false);
        return new ApiResponse("ok",true,optionalCustomer.get());
    }

    public ApiResponse deleteCustomer(int id) {
        boolean exists = customerRepository.existsById(id);
        if (!exists)return new ApiResponse("Not Found",false);
        customerRepository.deleteById(id);
        return new ApiResponse("Deleted",true);
    }
}
