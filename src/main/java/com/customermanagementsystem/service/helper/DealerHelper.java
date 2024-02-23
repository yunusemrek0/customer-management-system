package com.customermanagementsystem.service.helper;

import com.customermanagementsystem.entity.product.Dealer;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.product.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealerHelper {

    private final DealerRepository dealerRepository;


    public Dealer isExistById(Long id){
        return dealerRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.DEALER_NOT_FOUND_ID,id))
        );
    }


    public void dealerBalanceCalculatorForPurchase(Dealer dealer,Double totalPurchase){

        double newBalance = dealer.getBalance()+totalPurchase;
        dealer.setBalance(newBalance);
        dealerRepository.save(dealer);

    }
}
