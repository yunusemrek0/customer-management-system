package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyFuelOilSale;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.dailysale.DailyFuelOilSaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.DailyFuelOilSaleRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.repository.dailysale.DailyFuelOilSaleRepository;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyFuelOilSaleService {

    private final DailyFuelOilSaleRepository dailyFuelOilSaleRepository;
    private final ProductHelper productHelper;
    private final DailyFuelOilSaleMapper dailyFuelOilSaleMapper;
    public String saveDailyFuelOilSale(DailyFuelOilSaleRequest dailyFuelOilSaleRequest) {

        Product product = productHelper.isExistById(dailyFuelOilSaleRequest.getProductId());

        DailyFuelOilSale dailyFuelOilSaleToSave = dailyFuelOilSaleMapper.mapFuelOilSaleRequestToFuelOilSale(dailyFuelOilSaleRequest);
        dailyFuelOilSaleToSave.setProduct(product);

        dailyFuelOilSaleRepository.save(dailyFuelOilSaleToSave);

        return SuccessMessages.SUCCESS;


    }

    public List<DailyFuelOilSaleResponse> getAll() {

        return dailyFuelOilSaleRepository.getByDailySaleIsNull()
                .stream()
                .map(dailyFuelOilSaleMapper::mapFuelOilSaleToFuelOilSaleResponse)
                .collect(Collectors.toList());
    }
}
