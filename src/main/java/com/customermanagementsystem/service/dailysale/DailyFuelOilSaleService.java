package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.dailysale.DailyFuelOilSale;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.dailysale.DailyFuelOilSaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.DailyFuelOilSaleRequest;
import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.dailysale.DailyFuelOilSaleResponse;
import com.customermanagementsystem.repository.dailysale.DailyFuelOilSaleRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DailyFuelOilSaleService {

    private final DailyFuelOilSaleRepository dailyFuelOilSaleRepository;
    private final ProductHelper productHelper;
    private final DailyFuelOilSaleMapper dailyFuelOilSaleMapper;
    private final DateTimeTranslator dateTimeTranslator;

    @Transactional
    public String saveDailyFuelOilSale(DailyFuelOilSaleRequest dailyFuelOilSaleRequest) {

        Product product = productHelper.isExistById(dailyFuelOilSaleRequest.getProductId());

        DailyFuelOilSale dailyFuelOilSaleToSave = dailyFuelOilSaleMapper.mapFuelOilSaleRequestToFuelOilSale(dailyFuelOilSaleRequest);
        dailyFuelOilSaleToSave.setProduct(product);

        dailyFuelOilSaleRepository.save(dailyFuelOilSaleToSave);
        productHelper.productStockCalculatorForDailySale(product,dailyFuelOilSaleRequest.getAmount());



        return SuccessMessages.SUCCESS;


    }

    public List<DailyFuelOilSaleResponse> getAll() {

        return dailyFuelOilSaleRepository.getByDailySaleIsNull()
                .stream()
                .map(dailyFuelOilSaleMapper::mapFuelOilSaleToFuelOilSaleResponse)
                .collect(Collectors.toList());
    }


    public List<DailyFuelOilSaleResponse> fuelOilSaleBetweenDate(DateTimeRequest dateTimeRequest) {
        List<Object[]> results = dailyFuelOilSaleRepository.findSalesSummary(dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                                                                             dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate()));
        List<DailyFuelOilSaleResponse> responseList = new ArrayList<>();

        for (Object[] result : results) {
            DailyFuelOilSaleResponse response = new DailyFuelOilSaleResponse();
            response.setId((Long) result[0]); // Ürün id'sini burada kullanıyoruz.
            response.setProductName((String) result[1]);
            response.setAmount((Double) result[2]);
            response.setTotal((Double) result[3]);
            responseList.add(response);
        }

        return responseList;
    }
}
