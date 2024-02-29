package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPomp;
import com.customermanagementsystem.entity.dailysale.fuelpomp.FuelPompStatistic;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.dailysale.fuelpomp.FuelPompMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToSave;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToUpdate;
import com.customermanagementsystem.repository.dailysale.fuelpomp.FuelPompRepository;
import com.customermanagementsystem.repository.dailysale.fuelpomp.FuelPompStatisticRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.FuelPompHelper;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuelPompService {

    private final FuelPompRepository fuelPompRepository;
    private final FuelPompMapper fuelPompMapper;
    private final ProductHelper productHelper;
    private final FuelPompHelper fuelPompHelper;
    private final DateTimeTranslator dateTimeTranslator;
    private final FuelPompStatisticRepository fuelPompStatisticRepository;

    public String saveFuelPomp(FuelPompRequestToSave fuelPompRequest) {

        Product product = productHelper.isExistById(fuelPompRequest.getProductId());

        FuelPomp fuelPompToSave = fuelPompMapper.mapFuelPompRequestToSaveToFuelPomp(fuelPompRequest);
        fuelPompToSave.setProduct(product);

        fuelPompRepository.save(fuelPompToSave);

        return SuccessMessages.FUEL_POMP_SAVE;

    }

    public String updateFuelPomp(FuelPompRequestToUpdate fuelPompRequest, Long id) {

        FuelPomp fuelPomp = fuelPompHelper.isExistById(id);

        FuelPomp fuelPompToUpdate = fuelPompMapper.mapFuelPompRequestToUpdateToFuelPomp(fuelPompRequest);
        fuelPompToUpdate.setId(id);
        fuelPompToUpdate.setName(fuelPomp.getName());
        fuelPompToUpdate.setProduct(fuelPomp.getProduct());
        fuelPompToUpdate.setCreationDate(fuelPomp.getCreationDate());
        fuelPompToUpdate.setOldNumerator(fuelPomp.getNewNumerator());

        FuelPomp savedFuelPomp = fuelPompRepository.save(fuelPompToUpdate);
        fuelPompStatisticMaker(savedFuelPomp);

        return SuccessMessages.FUEL_POMP_UPDATE;
    }

    private void fuelPompStatisticMaker(FuelPomp fuelPomp){

        double amount = fuelPomp.getNewNumerator() - fuelPomp.getOldNumerator();
        double total = amount * fuelPomp.getProduct().getPriceForCash();

        FuelPompStatistic fuelPompStatisticToSave = FuelPompStatistic.builder()
                .fuelPomp(fuelPomp)
                .product(fuelPomp.getProduct())
                .total(total)
                .amountAsLiter(amount)
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();

        fuelPompStatisticRepository.save(fuelPompStatisticToSave);
    }
}
