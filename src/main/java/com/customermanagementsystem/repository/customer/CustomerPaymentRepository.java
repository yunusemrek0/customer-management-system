package com.customermanagementsystem.repository.customer;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment,Long> {

    List<CustomerPayment> getByCustomerId(Long customerId);
}
