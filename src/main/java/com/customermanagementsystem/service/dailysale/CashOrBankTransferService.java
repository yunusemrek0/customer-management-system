package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.dailysale.BankTransfer;
import com.customermanagementsystem.entity.dailysale.CashDelivery;
import com.customermanagementsystem.payload.mapper.dailysale.BankAndCashMapper;
import com.customermanagementsystem.payload.request.dailysale.BankAndCashRequest;
import com.customermanagementsystem.payload.response.dailysale.BankAndCashResponse;
import com.customermanagementsystem.repository.dailysale.BankTransferRepository;
import com.customermanagementsystem.repository.dailysale.CashDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CashOrBankTransferService {

    private final BankTransferRepository bankTransferRepository;
    private final CashDeliveryRepository cashDeliveryRepository;
    private final BankAndCashMapper bankAndCashMapper;

    public String saveCashDelivery(BankAndCashRequest request) {

        CashDelivery cashDeliveryToSave = bankAndCashMapper.mapRequestToCash(request);
        cashDeliveryRepository.save(cashDeliveryToSave);
        return null;
    }

    public List<BankAndCashResponse> getAllCashDelivery() {
        return cashDeliveryRepository.getByDailySaleIsNull()
                .stream()
                .map(bankAndCashMapper::mapBankOrCashToResponse)
                .collect(Collectors.toList());
    }

    public String saveBankTransfer(BankAndCashRequest request) {
        BankTransfer bankTransferToSave = bankAndCashMapper.mapRequestToBank(request);
        bankTransferRepository.save(bankTransferToSave);
        return null;
    }

    public List<BankAndCashResponse> getAllBankTransfer() {
        return bankTransferRepository.getByDailySaleIsNull()
                .stream()
                .map(bankAndCashMapper::mapBankOrCashToResponse)
                .collect(Collectors.toList());
    }

    public String deleteBankTransferById(Long id) {
        bankTransferRepository.deleteById(id);
        return null;
    }

    public String deleteCashDeliveryById(Long id) {
        cashDeliveryRepository.deleteById(id);
        return null;
    }
}
