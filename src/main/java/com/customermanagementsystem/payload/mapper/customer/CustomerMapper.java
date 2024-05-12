package com.customermanagementsystem.payload.mapper.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.customer.forwardsale.LateCharge;
import com.customermanagementsystem.payload.request.customer.CustomerRequest;
import com.customermanagementsystem.payload.response.customer.CustomerDetailResponse;
import com.customermanagementsystem.payload.response.customer.CustomerResponse;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<CustomerDetailResponse> mapAllDetailsToCustomerDetailResponse(List<ForwardSale> forwardSales,
                                                                        List<CustomerPayment> customerPayments,
                                                                        List<LateCharge> lateCharges){
        List<CustomerDetailResponse> customerDetailResponses = new ArrayList<>();

        for (ForwardSale forwardSale:forwardSales){

            customerDetailResponses.add(CustomerDetailResponse.builder()
                    .dateTimeFS(forwardSale.getDateTime())
                    .amountFS(forwardSale.getAmount())
                    .totalFS(forwardSale.getTotal())
                    .unitPriceFS(forwardSale.getUnitPrice())
                    .productNameFS(forwardSale.getProduct().getName())
                    .build());
       }

        for (CustomerPayment customerPayment:customerPayments){
            customerDetailResponses.add(CustomerDetailResponse.builder()
                    .dateTimeCP(customerPayment.getDateTime())
                    .totalCP(customerPayment.getTotal())
                    .build());
        }

        for (LateCharge lateCharge:lateCharges){

            customerDetailResponses.add(CustomerDetailResponse.builder()
                    .dateTimeLC(lateCharge.getDateTime())
                    .totalLC(lateCharge.getTotal())
                    .build());
        }

        return customerDetailResponses;

    }

}
