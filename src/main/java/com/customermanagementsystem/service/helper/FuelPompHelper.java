package com.customermanagementsystem.service.helper;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPomp;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.dailysale.fuelpomp.FuelPompRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FuelPompHelper {

    private final FuelPompRepository fuelPompRepository;


    public FuelPomp isExistById(Long id){
        return fuelPompRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.FUEL_POMP_NOT_FOUND_ID,id))
        );
    }

    public List<FuelPomp> getByTransferredIsNull(){
        return fuelPompRepository.getByIsTransferredIsNull();
    }

    public void makeIsTransferredTrue(List<FuelPomp> fuelPomps){
        for (FuelPomp fuelPomp:fuelPomps){
            fuelPomp.setIsTransferred(true);
            fuelPompRepository.save(fuelPomp);
        }
    }
}
