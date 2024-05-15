package com.customermanagementsystem.service.helper.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTank;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.fueltank.FuelTankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuelTankHelper {

    private final FuelTankRepository fuelTankRepository;

    public FuelTank isExistById(Long id){
        return fuelTankRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.CUSTOMER_NOT_FOUND_ID,id))
        );
    }

    public void fuelTankAmountCalculatorForFilling(FuelTank fuelTank,Double amount){

        double newAmount = fuelTank.getAmountInside() + amount;
        fuelTank.setAmountInside(newAmount);
        fuelTankRepository.save(fuelTank);
    }

    public void fuelTankAmountCalculatorForSale(FuelTank fuelTank,Double amount){

        double newAmount = fuelTank.getAmountInside() - amount;
        fuelTank.setAmountInside(newAmount);
        fuelTankRepository.save(fuelTank);
    }
}
