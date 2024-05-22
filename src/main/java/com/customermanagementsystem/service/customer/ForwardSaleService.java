package com.customermanagementsystem.service.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.customer.ForwardSaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.customer.ForwardSaleRequest;
import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.customer.ForwardSaleResponse;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.repository.customer.ForwardSaleRepository;
import com.customermanagementsystem.service.helper.CustomerHelper;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ForwardSaleService {

    private final ForwardSaleRepository forwardSaleRepository;
    private final ProductHelper productHelper;
    private final CustomerHelper customerHelper;
    private final ForwardSaleMapper forwardSaleMapper;
    private final DateTimeTranslator dateTimeTranslator;


    @Transactional
    public String saveForwardSale(ForwardSaleRequest forwardSaleRequest) {

        Product product = productHelper.isExistById(forwardSaleRequest.getProductId());
        Customer customer = customerHelper.isExistById(forwardSaleRequest.getCustomerId());


        ForwardSale forwardSaleToSave = forwardSaleMapper.mapForwardSaleRequestToForwardSale(forwardSaleRequest,product.getPriceForCash());
        forwardSaleToSave.setCustomer(customer);
        forwardSaleToSave.setProduct(product);

        forwardSaleRepository.save(forwardSaleToSave);

        customerHelper.customerBalanceCalculatorForSale(customer,forwardSaleToSave.getTotal());

        return SuccessMessages.FORWARD_SALE_SAVE;
    }

    public List<ForwardSaleResponse> getByCustomer(Long customerId) {

        customerHelper.isExistById(customerId);

        return forwardSaleRepository.getByCustomerId(customerId)
                .stream()
                .map(forwardSaleMapper::mapForwardSaleToForwardSaleResponse)
                .collect(Collectors.toList());


    }

    public List<ForwardSaleResponse> getAll() {

        return forwardSaleRepository.getByDailySaleIsNull()
                .stream()
                .map(forwardSaleMapper::mapForwardSaleToForwardSaleResponse)
                .collect(Collectors.toList());
    }

    public Double forwardSaleTotalBetweenDate(DateTimeRequest dateTimeRequest) {
        return forwardSaleRepository.
                findTotalForwardSaleBetweenDate(dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                                                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate()));
    }

    public List<ForwardSaleResponse> adBlueAndVehicleMatic(DateTimeRequest dateTimeRequest) {

        List<Object[]> results = forwardSaleRepository.findAdBlueAndVehicleMatic(
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate()));

        List<ForwardSaleResponse> responseList = new ArrayList<>();

        for (Object[] result : results) {
            ForwardSaleResponse response = new ForwardSaleResponse();
            response.setId((Long) result[0]); // Ürün id'sini burada kullanıyoruz.
            response.setProductName((String) result[1]);
            response.setAmount((Double) result[2]);
            response.setTotal((Double) result[3]);
            responseList.add(response);
        }

        return responseList;

    }
}
