package com.customermanagementsystem.payload.mapper.customer;

import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.payload.request.customer.ForwardSaleRequest;
import com.customermanagementsystem.payload.response.customer.ForwardSaleResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ForwardSaleMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;


    //TODO cashPrice will be added.
    public ForwardSale mapForwardSaleRequestToForwardSale(ForwardSaleRequest forwardSaleRequest,Double cashPrice){

        return ForwardSale.builder()
                .cashPrice(mapperHelper.formatDoubleValue(cashPrice))
                .unitPrice(mapperHelper.formatDoubleValue(forwardSaleRequest.getUnitPrice()))
                .amount(mapperHelper.formatDoubleValue(forwardSaleRequest.getAmount()))
                .description(forwardSaleRequest.getDescription())
                .total(mapperHelper.formatDoubleValue(forwardSaleRequest.getUnitPrice()*forwardSaleRequest.getAmount()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }


    public ForwardSaleResponse mapForwardSaleToForwardSaleResponse(ForwardSale forwardSale){

        return ForwardSaleResponse.builder()
                .id(forwardSale.getId())
                .dateTime(forwardSale.getDateTime())
                .productName(forwardSale.getProduct().getName())
                .unitPrice(mapperHelper.formatDoubleValue(forwardSale.getUnitPrice()))
                .amount(mapperHelper.formatDoubleValue(forwardSale.getAmount()))
                .total(mapperHelper.formatDoubleValue(forwardSale.getTotal()))
                .customerName(forwardSale.getCustomer().getName())
                .description(forwardSale.getDescription())
                .build();
    }
}
