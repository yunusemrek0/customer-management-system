package com.customermanagementsystem.service.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.customer.forwardsale.LateCharge;
import com.customermanagementsystem.payload.mapper.customer.LateChargeMapper;
import com.customermanagementsystem.payload.request.customer.LateChargeRequest;
import com.customermanagementsystem.repository.customer.LateChargeRepository;
import com.customermanagementsystem.service.helper.CustomerHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LateChargeService {

    private final LateChargeRepository lateChargeRepository;
    private final CustomerHelper customerHelper;
    private final LateChargeMapper lateChargeMapper;


    @Transactional
    public String saveLateCharge(LateChargeRequest lateChargeRequest) {

        Customer customer = customerHelper.isExistById(lateChargeRequest.getCustomerId());
        LateCharge lateChargeToSave = lateChargeMapper.mapLateChargeRequestToLateCharge(lateChargeRequest);
        lateChargeToSave.setCustomer(customer);

        lateChargeRepository.save(lateChargeToSave);
        customerHelper.customerBalanceCalculatorForLateCharge(customer,lateChargeRequest.getTotal());

        return "VADE FARKI BAŞARILI BİR ŞEKİLDE KAYDEDİLDİ.";
    }
}
