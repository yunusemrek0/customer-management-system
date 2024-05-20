package com.customermanagementsystem.repository.customer;

import com.customermanagementsystem.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByNameIgnoreCaseContaining(String name);

    @Query("SELECT SUM(c.balance) FROM Customer c")
    Double findSumOfBalance();
}
