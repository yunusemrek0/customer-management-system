package com.customermanagementsystem.service.product;

import com.customermanagementsystem.entity.product.Dealer;
import com.customermanagementsystem.entity.product.DealerPayment;
import com.customermanagementsystem.payload.mapper.product.DealerPaymentMapper;
import com.customermanagementsystem.payload.request.product.DealerPaymentRequest;
import com.customermanagementsystem.payload.response.product.DealerPaymentResponse;
import com.customermanagementsystem.repository.product.DealerPaymentRepository;
import com.customermanagementsystem.service.helper.DealerHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DealerPaymentService {

    private final DealerHelper dealerHelper;
    private final DealerPaymentMapper dealerPaymentMapper;
    private final DealerPaymentRepository dealerPaymentRepository;


    @Transactional
    public String saveDealerPayment(DealerPaymentRequest dealerPaymentRequest) {
        Dealer dealer = dealerHelper.isExistById(dealerPaymentRequest.getDealerId());
        DealerPayment dealerPaymentToSave = dealerPaymentMapper.mapDealerPaymentRequestToDealerPayment(dealerPaymentRequest);
        dealerPaymentToSave.setDealer(dealer);
        dealerPaymentRepository.save(dealerPaymentToSave);

        dealerHelper.dealerBalanceCalculatorForPayment(dealer,dealerPaymentRequest.getTotal());

        return null;
    }

    public List<DealerPaymentResponse> getAll() {
        return dealerPaymentRepository.findAll()
                .stream()
                .map(dealerPaymentMapper::mapDealerPaymentToDealerPaymentResponse)
                .collect(Collectors.toList());
    }

}
