package com.customermanagementsystem.payload.mapper.dailysale.posdevice;

import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.payload.request.dailysale.posdevice.PosDeviceSaleRequest;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceSaleResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PosDeviceSaleMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;


    public PosDeviceSale mapPosDeviceSaleRequestToPosDeviceSale(PosDeviceSaleRequest posDeviceSaleRequest){

        return PosDeviceSale.builder()
                .total(mapperHelper.formatDoubleValue(posDeviceSaleRequest.getTotal()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }


    public PosDeviceSaleResponse mapPosDeviceSaleToPosDeviceSaleResponse(PosDeviceSale posDeviceSale){

        return PosDeviceSaleResponse.builder()
                .id(posDeviceSale.getId())
                .total(mapperHelper.formatDoubleValue(posDeviceSale.getTotal()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .posDeviceName(posDeviceSale.getPosDevice().getName())
                .build();
    }
}
