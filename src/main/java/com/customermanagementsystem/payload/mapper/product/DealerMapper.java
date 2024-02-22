package com.customermanagementsystem.payload.mapper.product;

import com.customermanagementsystem.entity.product.Dealer;
import com.customermanagementsystem.payload.request.product.DealerRequest;
import com.customermanagementsystem.payload.response.product.DealerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DealerMapper {


    public Dealer mapDealerRequestToDealer(DealerRequest dealerRequest){

        return Dealer.builder()
                .name(dealerRequest.getName())
                .balance(dealerRequest.getBalance())
                .build();
    }


    public DealerResponse mapDealerToDealerResponse(Dealer dealer){

        return DealerResponse.builder()
                .id(dealer.getId())
                .name(dealer.getName())
                .balance(dealer.getBalance())
                .build();
    }
}
