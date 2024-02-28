package com.customermanagementsystem.service.helper.dailysale;

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

    @Transactional
    public List<FuelPompStatistic> fuelPompStatisticCalculator(){

        List<FuelPompStatistic> fuelPompStatistics = new ArrayList<>();
        List<FuelPomp> fuelPompUnTransferred = fuelPompHelper.getByTransferredIsNull();

        for (FuelPomp fuelPomp:fuelPompUnTransferred){

            double amount = fuelPomp.getNewNumerator() - fuelPomp.getOldNumerator();
            double total = amount * fuelPomp.getProduct().getPriceForCash();

            FuelPompStatistic fuelPompStatisticToSave = FuelPompStatistic.builder()
                    .fuelPomp(fuelPomp)
                    .product(fuelPomp.getProduct())
                    .total(total)
                    .dateTime(dateTimeTranslator.parseLocalDateTime())
                    .build();

            FuelPompStatistic fuelPompStatistic = fuelPompStatisticRepository.save(fuelPompStatisticToSave);
            fuelPompStatistics.add(fuelPompStatistic);

    }


        return fuelPompStatistics;
    }


    public double totalFuelPompSales(List<FuelPompStatistic> fuelPompStatistics){
        double total=0;

        for (FuelPompStatistic fuelPompStatistic:fuelPompStatistics){
            total+=fuelPompStatistic.getTotal();
        }

        return total;
    }
}
