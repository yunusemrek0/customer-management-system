package com.customermanagementsystem.repository.customer;

import com.customermanagementsystem.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> getByNameContains(String name);
}
