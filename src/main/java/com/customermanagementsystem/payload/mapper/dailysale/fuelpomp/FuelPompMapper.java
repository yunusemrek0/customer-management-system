package com.customermanagementsystem.payload.mapper.dailysale.fuelpomp;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPomp;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToSave;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToUpdate;
import com.customermanagementsystem.payload.response.dailysale.fuelpomp.FuelPompResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuelPompMapper {

    private final DateTimeTranslator dateTimeTranslator;


    public FuelPomp mapFuelPompRequestToSaveToFuelPomp(FuelPompRequestToSave fuelPompRequest){

        return FuelPomp.builder()
                .creationDate(dateTimeTranslator.parseLocalDateTime())
                .name(fuelPompRequest.getName())
                .oldNumerator(fuelPompRequest.getOldNumerator())
                .newNumerator(fuelPompRequest.getOldNumerator())
                .build();
    }

    public FuelPomp mapFuelPompRequestToUpdateToFuelPomp(FuelPompRequestToUpdate fuelPompRequest){

        return FuelPomp.builder()
                .newNumerator(fuelPompRequest.getNewNumerator())
                .updateDateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }

    public FuelPompResponse mapFuelPompToFuelPompResponse(FuelPomp fuelPomp){

        return FuelPompResponse.builder()
                .id(fuelPomp.getId())
                .isTransferred(fuelPomp.getIsTransferred())
                .productName(fuelPomp.getProduct().getName())
                .updateDateTime(fuelPomp.getUpdateDateTime())
                .name(fuelPomp.getName())
                .newNumerator(fuelPomp.getNewNumerator())
                .oldNumerator(fuelPomp.getOldNumerator())
                .build();
    }
}
