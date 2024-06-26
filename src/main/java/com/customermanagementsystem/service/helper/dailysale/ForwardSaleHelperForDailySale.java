package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.repository.customer.ForwardSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ForwardSaleHelperForDailySale {

    private final ForwardSaleRepository forwardSaleRepository;


    public List<ForwardSale> getByDailySaleIsNull(){

        return forwardSaleRepository.getByDailySaleIsNull();
    }

    public double totalSaleAsCash(List<ForwardSale> forwardSales){
        double total =0;
        for (ForwardSale forwardSale:forwardSales){
            total=total+(  (forwardSale.getCashPrice() * forwardSale.getAmount()) );
        }

        return total;
    }

    public double totalSaleAsForward(List<ForwardSale> forwardSales){
        double total =0;
        for (ForwardSale forwardSale:forwardSales){
            total+=forwardSale.getTotal();
        }

        return total;
    }

    public void saveDailySaleForForwardSale(List<ForwardSale> forwardSales, DailySale dailySale){
        for (ForwardSale forwardSale:forwardSales){
            forwardSale.setDailySale(dailySale);
            forwardSaleRepository.save(forwardSale);
        }
    }
}
