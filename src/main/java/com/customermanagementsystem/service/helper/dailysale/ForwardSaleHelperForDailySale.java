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




    public void forwardSaleCalculatorForDailySale(DailySale dailySale){

        //dailySale.setDailyForwardSaleForDiesel();

    }


/*
    @OneToMany(mappedBy = "dailySale")
    private List<ForwardSale> forwardSales;

    private Double dailyForwardSaleForDiesel;

    private Double dailyForwardSaleAsLiterForDiesel;

    private Double dailyForwardSaleForGasoline;

    private Double dailyForwardSaleAsLiterForGasoline;

    private Double dailyForwardSaleForGas;

    private Double dailyForwardSaleAsLiterForGas;
 */
}
