package com.customermanagementsystem.service.helper;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerHelper {

    private final CustomerRepository customerRepository;

    public Customer isExistById(Long id){
        return customerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.CUSTOMER_NOT_FOUND_ID,id))
        );
    }

    public void customerBalanceCalculatorForPayment(Customer customer, Double totalPayment){

        double newBalance = customer.getBalance()-totalPayment;
        customer.setBalance(newBalance);
        customerRepository.save(customer);
    }

    public void customerBalanceCalculatorForSale(Customer customer, Double totalSale){

        double newBalance = customer.getBalance()+totalSale;
        customer.setBalance(newBalance);
        customerRepository.save(customer);
    }

    public void customerBalanceCalculatorForLateCharge(Customer customer, Double total){
        double newBalance = customer.getBalance() + total;
        customer.setBalance(newBalance);
        customerRepository.save(customer);
    }
}
