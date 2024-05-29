package com.customermanagementsystem.payload.mapper.customer;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.payload.request.customer.CustomerPaymentRequest;
import com.customermanagementsystem.payload.response.customer.CustomerPaymentResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class CustomerPaymentMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;

    public CustomerPayment mapCustomerPaymentRequestToCustomerPayment(CustomerPaymentRequest customerPaymentRequest){

        return CustomerPayment.builder()
                .total(mapperHelper.formatDoubleValue(customerPaymentRequest.getTotal()))
                .description(customerPaymentRequest.getDescription())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .typeOfCustomerPayment(customerPaymentRequest.getTypeOfCustomerPayment())
                .build();
    }

    public CustomerPaymentResponse mapCustomerPaymentToCustomerPaymentResponse(CustomerPayment customerPayment){

        return CustomerPaymentResponse.builder()
                .id(customerPayment.getId())
                .total(mapperHelper.formatDoubleValue(customerPayment.getTotal()))
                .customerName(customerPayment.getCustomer().getName())
                .description(customerPayment.getDescription())
                .dateTime(customerPayment.getDateTime())
                //.typeOfCustomerPayment(customerPayment.getTypeOfCustomerPayment())
                .type("TAHSİLAT")
                .build();
    }


}
