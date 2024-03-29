package com.customermanagementsystem.payload.mapper.customer;

import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.payload.request.customer.ForwardSaleRequest;
import com.customermanagementsystem.payload.response.customer.ForwardSaleResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ForwardSaleMapper {

    private final DateTimeTranslator dateTimeTranslator;


    //TODO cashPrice will be added.
    public ForwardSale mapForwardSaleRequestToForwardSale(ForwardSaleRequest forwardSaleRequest,Double cashPrice){

        return ForwardSale.builder()
                .cashPrice(cashPrice)
                .unitPrice(forwardSaleRequest.getUnitPrice())
                .amount(forwardSaleRequest.getAmount())
                .total(forwardSaleRequest.getUnitPrice()*forwardSaleRequest.getAmount())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }


    public ForwardSaleResponse mapForwardSaleToForwardSaleResponse(ForwardSale forwardSale){

        return ForwardSaleResponse.builder()
                .id(forwardSale.getId())
                .dateTime(forwardSale.getDateTime())
                .productName(forwardSale.getProduct().getName())
                .unitPrice(forwardSale.getUnitPrice())
                .amount(forwardSale.getAmount())
                .total(forwardSale.getTotal())
                .customerName(forwardSale.getCustomer().getName())
                .build();
    }
}
