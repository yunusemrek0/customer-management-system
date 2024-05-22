package com.customermanagementsystem.payload.mapper.dailysale;

import com.customermanagementsystem.entity.dailysale.BankTransfer;
import com.customermanagementsystem.entity.dailysale.CashDelivery;
import com.customermanagementsystem.payload.request.dailysale.BankAndCashRequest;
import com.customermanagementsystem.payload.response.dailysale.BankAndCashResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankAndCashMapper {

    private final DateTimeTranslator dateTimeTranslator;

    public BankTransfer mapRequestToBank(BankAndCashRequest bankAndCashRequest){
        return BankTransfer.builder()
                .total(bankAndCashRequest.getTotal())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }

    public CashDelivery mapRequestToCash(BankAndCashRequest bankAndCashRequest){
        return CashDelivery.builder()
                .total(bankAndCashRequest.getTotal())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }

    public BankAndCashResponse mapBankOrCashToResponse(BankTransfer bankTransfer){
        return BankAndCashResponse.builder()
                .id(bankTransfer.getId())
                .dateTime(bankTransfer.getDateTime())
                .total(bankTransfer.getTotal())
                .build();
    }

    public BankAndCashResponse mapBankOrCashToResponse(CashDelivery cashDelivery){
        return BankAndCashResponse.builder()
                .id(cashDelivery.getId())
                .dateTime(cashDelivery.getDateTime())
                .total(cashDelivery.getTotal())
                .build();
    }
}
