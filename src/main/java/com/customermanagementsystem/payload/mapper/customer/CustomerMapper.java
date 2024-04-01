package com.customermanagementsystem.payload.mapper.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.payload.request.customer.CustomerRequest;
import com.customermanagementsystem.payload.response.customer.CustomerResponse;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerMapper {

    private final MapperHelper mapperHelper;

    public Customer mapCustomerRequestToCustomer(CustomerRequest customerRequest){

        return Customer.builder()
                .ssn(customerRequest.getSsn())
                .name(customerRequest.getName())
                .taxNo(customerRequest.getTaxNo())
                .taxOffice(customerRequest.getTaxOffice())
                .address(customerRequest.getAddress())
                .description(customerRequest.getDescription())
                .balance(mapperHelper.formatDoubleValue(customerRequest.getBalance()))
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
                .balance(mapperHelper.formatDoubleValue(customer.getBalance()))
                .mobilePhone(customer.getMobilePhone())
                .build();
    }
}
