package com.customermanagementsystem.payload.mapper.product;

import com.customermanagementsystem.entity.product.DealerPayment;
import com.customermanagementsystem.payload.request.product.DealerPaymentRequest;
import com.customermanagementsystem.payload.response.product.DealerPaymentResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealerPaymentMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;

    public DealerPayment mapDealerPaymentRequestToDealerPayment(DealerPaymentRequest dealerPaymentRequest){
        return DealerPayment.builder()
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .total(mapperHelper.formatDoubleValue(dealerPaymentRequest.getTotal()))
                .build();
    }

    public DealerPaymentResponse mapDealerPaymentToDealerPaymentResponse(DealerPayment dealerPayment){
        return DealerPaymentResponse.builder()
                .id(dealerPayment.getId())
                .dealerName(dealerPayment.getDealer().getName())
                .total(dealerPayment.getTotal())
                .dateTime(dealerPayment.getDateTime())
                .build();
    }
}
