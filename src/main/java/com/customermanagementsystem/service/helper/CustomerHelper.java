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
}
