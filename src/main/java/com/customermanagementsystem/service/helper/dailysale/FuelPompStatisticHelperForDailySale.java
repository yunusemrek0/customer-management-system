package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPomp;
import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPompStatistic;
import com.customermanagementsystem.repository.dailysale.fuelpomp.FuelPompStatisticRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.FuelPompHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FuelPompStatisticHelperForDailySale {

    private final FuelPompHelper fuelPompHelper;
    private final DateTimeTranslator dateTimeTranslator;
    private final FuelPompStatisticRepository fuelPompStatisticRepository;

    public List<FuelPompStatistic> getByDailySaleIsNull(){

        return fuelPompStatisticRepository.getByDailySaleIsNull();
    }


    public double totalFuelPompSales(List<FuelPompStatistic> fuelPompStatistics){
        double total=0;

        for (FuelPompStatistic fuelPompStatistic:fuelPompStatistics){
            total+=fuelPompStatistic.getTotal();
        }

        return total;
    }


    public void saveDailySaleForFuelStatistic(List<FuelPompStatistic> fuelPompStatistics, DailySale dailySale){
        for (FuelPompStatistic fuelPompStatistic:fuelPompStatistics){
            fuelPompStatistic.setDailySale(dailySale);
            fuelPompStatisticRepository.save(fuelPompStatistic);
        }
    }
}
