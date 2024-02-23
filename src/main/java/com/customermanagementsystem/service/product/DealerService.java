package com.customermanagementsystem.service.product;

import com.customermanagementsystem.entity.product.Dealer;
import com.customermanagementsystem.payload.mapper.product.DealerMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.product.DealerRequest;
import com.customermanagementsystem.payload.response.product.DealerResponse;
import com.customermanagementsystem.repository.product.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;
    private final DealerMapper dealerMapper;


    public String saveDealer(DealerRequest dealerRequest) {

        Dealer dealerToSave = dealerMapper.mapDealerRequestToDealer(dealerRequest);

        dealerRepository.save(dealerToSave);

        return SuccessMessages.DEALER_SAVE;
    }

    public List<DealerResponse> getAll() {

        return dealerRepository.findAll()
                .stream()
                .map(dealerMapper::mapDealerToDealerResponse)
                .collect(Collectors.toList());
    }
}
