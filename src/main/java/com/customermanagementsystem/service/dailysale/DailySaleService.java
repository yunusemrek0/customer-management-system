package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.repository.dailysale.DailySaleRepository;
import com.customermanagementsystem.service.helper.dailysale.ForwardSaleHelperForDailySale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailySaleService {

    private final DailySaleRepository dailySaleRepository;
    private final ForwardSaleHelperForDailySale helper;

    public String saveDailySale(DailySaleRequest dailySaleRequest) {



        List<ForwardSale> forwardSales = helper.getByDailySaleIsNull();



        return null;
    }
}
