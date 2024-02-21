package com.customermanagementsystem.payload.mapper.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.payload.request.customer.CustomerRequest;
import com.customermanagementsystem.payload.response.customer.CustomerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    public Customer mapCustomerRequestToCustomer(CustomerRequest customerRequest){

        return Customer.builder()
                .ssn(customerRequest.getSsn())
                .name(customerRequest.getName())
                .taxNo(customerRequest.getTaxNo())
                .taxOffice(customerRequest.getTaxOffice())
                .address(customerRequest.getAddress())
                .description(customerRequest.getDescription())
                .balance(customerRequest.getBalance())
                .mobilePhone(customerRequest.getMobilePhone())
                .build();
    }

    public CustomerResponse mapCustomerToCustomerResponse(Customer customer){

        return CustomerResponse .builder()
                .id(customer.getId())
                .ssn(customer.getSsn())
                .name(customer.getName())
                .taxNo(customer.getTaxNo())
                .taxOffice(customer.getTaxOffice())
                .address(customer.getAddress())
                .description(customer.getDescription())
                .balance(customer.getBalance())
                .mobilePhone(customer.getMobilePhone())
                .build();
    }
}
