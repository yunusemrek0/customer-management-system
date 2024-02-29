package com.customermanagementsystem.payload.mapper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailySaleMapper {

    private final DateTimeTranslator dateTimeTranslator;

    public DailySale mapDailySaleRequestToDailySale(DailySaleRequest dailySaleRequest){
        return DailySale.builder()
                .reportZ(dailySaleRequest.getReportZ())
                .totalCash(dailySaleRequest.getTotalCash())
                .bankTransferTotal(dailySaleRequest.getBankTransferTotal())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }



}
