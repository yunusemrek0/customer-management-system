package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.fueltank.FuelTankSale;
import com.customermanagementsystem.repository.fueltank.FuelTankSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FuelTankSaleHelperForDailySale {

    private final FuelTankSaleRepository fuelTankSaleRepository;


    public List<FuelTankSale> getByDailySaleIsNull() {
        return fuelTankSaleRepository.getByDailySaleIsNull();
    }

    public double totalFuelTankSale(List<FuelTankSale> fuelTankSales) {

        double total = 0;

        for (FuelTankSale fuelTankSale:fuelTankSales){
            total += fuelTankSale.getTotal();
        }
        return total;
    }

    public void saveDailySaleForFuelTankSale(List<FuelTankSale> fuelTankSales, DailySale savedDailySale) {
        for (FuelTankSale fuelTankSale:fuelTankSales){
            fuelTankSale.setDailySale(savedDailySale);
            fuelTankSaleRepository.save(fuelTankSale);
        }
    }
}
