package com.customermanagementsystem.payload.mapper.dailysale.posdevice;

import com.customermanagementsystem.entity.dailysale.posdevice.PosDevice;
import com.customermanagementsystem.payload.request.dailysale.posdevice.PosDeviceRequest;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PosDeviceMapper {

    private final DateTimeTranslator dateTimeTranslator;


    public PosDevice mapPosDeviceRequestToPosDevice(PosDeviceRequest posDeviceRequest){

        return PosDevice.builder()
                .name(posDeviceRequest.getName())
                .creationDate(dateTimeTranslator.parseLocalDateTime())
                .build();
    }


    public PosDeviceResponse mapPosDeviceToPosDeviceResponse(PosDevice posDevice){

        return PosDeviceResponse.builder()
                .id(posDevice.getId())
                .name(posDevice.getName())
                .creationDate(posDevice.getCreationDate())
                .build();
    }

}
