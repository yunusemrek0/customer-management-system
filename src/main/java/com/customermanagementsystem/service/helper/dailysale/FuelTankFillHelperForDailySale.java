package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.fueltank.FuelTankFill;
import com.customermanagementsystem.repository.fueltank.FuelTankFillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FuelTankFillHelperForDailySale {

    private final FuelTankFillRepository fuelTankFillRepository;

    public List<FuelTankFill> getByDailySaleIsNull() {
        return fuelTankFillRepository.getByDailySaleIsNull();
    }

    public double totalFuelTankFill(List<FuelTankFill> fuelTankFills) {
        double total = 0;

        for (FuelTankFill fuelTankFill:fuelTankFills){
            total += fuelTankFill.getTotal();
        }
        return total;
    }

    public void saveDailySaleForFuelTankFill(List<FuelTankFill> fuelTankFills, DailySale savedDailySale) {
        for (FuelTankFill fuelTankFill: fuelTankFills){
            fuelTankFill.setDailySale(savedDailySale);
            fuelTankFillRepository.save(fuelTankFill);
        }
    }
}
