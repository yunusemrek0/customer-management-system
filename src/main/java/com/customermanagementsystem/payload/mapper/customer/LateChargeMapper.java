package com.customermanagementsystem.payload.mapper.customer;

import com.customermanagementsystem.entity.customer.forwardsale.LateCharge;
import com.customermanagementsystem.payload.request.customer.LateChargeRequest;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LateChargeMapper {

    private final DateTimeTranslator dateTimeTranslator;


    public LateCharge mapLateChargeRequestToLateCharge(LateChargeRequest lateChargeRequest){

        return LateCharge.builder()
                .total(lateChargeRequest.getTotal())
                .description(lateChargeRequest.getDescription())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();

    }
}
