package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyFuelOilSale;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.repository.dailysale.DailyFuelOilSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DailyFuelOilSaleHelperForDailySale {

    private final DailyFuelOilSaleRepository dailyFuelOilSaleRepository;


    public List<DailyFuelOilSale> getByDailySaleIsNull() {
        return dailyFuelOilSaleRepository.getByDailySaleIsNull();
    }

    public double totalFuelOilSales(List<DailyFuelOilSale> dailyFuelOilSales) {

        double total=0;

        for (DailyFuelOilSale dailyFuelOilSale:dailyFuelOilSales){
            total+=(dailyFuelOilSale.getProduct().getPriceForCash() * dailyFuelOilSale.getAmount());
        }

        return total;
    }

    public double totalFuelOilSalesAsPurchasePrice(List<DailyFuelOilSale> dailyFuelOilSales) {

        double total=0;

        for (DailyFuelOilSale dailyFuelOilSale:dailyFuelOilSales){
            total+=(dailyFuelOilSale.getProduct().getPurchasePrice() * dailyFuelOilSale.getAmount());
        }

        return total;
    }

    public void saveDailySaleForFuelOilSales(List<DailyFuelOilSale> fuelOilSales, DailySale dailySale){
        for (DailyFuelOilSale fuelOilSale:fuelOilSales){
            fuelOilSale.setDailySale(dailySale);
            dailyFuelOilSaleRepository.save(fuelOilSale);
        }
    }
}
