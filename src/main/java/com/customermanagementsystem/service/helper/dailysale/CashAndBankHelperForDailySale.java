package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.dailysale.BankTransfer;
import com.customermanagementsystem.entity.dailysale.CashDelivery;
import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.repository.dailysale.BankTransferRepository;
import com.customermanagementsystem.repository.dailysale.CashDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CashAndBankHelperForDailySale {

    private final BankTransferRepository bankTransferRepository;
    private final CashDeliveryRepository cashDeliveryRepository;

    public List<BankTransfer> getByDailySaleIsNullBank() {
        return bankTransferRepository.getByDailySaleIsNull();
    }

    public List<CashDelivery> getByDailySaleIsNullCash() {
        return cashDeliveryRepository.getByDailySaleIsNull();
    }

    public double totalBankTransfer(List<BankTransfer> bankTransfers) {
        double total = 0;
        for (BankTransfer bankTransfer:bankTransfers){
            total+=bankTransfer.getTotal();
        }
        return total;
    }

    public double totalCashDelivery(List<CashDelivery> cashDeliveries) {
        double total = 0;
        for (CashDelivery cashDelivery:cashDeliveries){
            total+=cashDelivery.getTotal();
        }
        return total;
    }

    public void saveDailySaleForBankTransfer(List<BankTransfer> bankTransfers, DailySale savedDailySale) {
        for (BankTransfer bankTransfer:bankTransfers){
            bankTransfer.setDailySale(savedDailySale);
            bankTransferRepository.save(bankTransfer);
        }
    }

    public void saveDailySaleForCashDelivery(List<CashDelivery> cashDeliveries, DailySale savedDailySale) {
        for (CashDelivery cashDelivery:cashDeliveries){
            cashDelivery.setDailySale(savedDailySale);
            cashDeliveryRepository.save(cashDelivery);
        }
    }
}
