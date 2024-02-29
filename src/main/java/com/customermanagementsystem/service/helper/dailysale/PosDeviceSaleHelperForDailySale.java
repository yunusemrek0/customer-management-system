package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.repository.dailysale.posdevice.PosDeviceSaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PosDeviceSaleHelperForDailySale {

    private final PosDeviceSaleRepository posDeviceSaleRepository;

    public List<PosDeviceSale> getByDailySaleIsNull(){
        return posDeviceSaleRepository.getByDailySaleIsNull();
    }

    public double totalPosDeviceSale(List<PosDeviceSale> posDeviceSales){
        double total=0;

        for (PosDeviceSale posDeviceSale:posDeviceSales){
            total+=posDeviceSale.getTotal();
        }

        return total;
    }

    public void saveDailySaleFoPosDeviceSale(List<PosDeviceSale> posDeviceSales, DailySale dailySale){
        for (PosDeviceSale posDeviceSale:posDeviceSales){
            posDeviceSale.setDailySale(dailySale);
            posDeviceSaleRepository.save(posDeviceSale);
        }
    }
}
