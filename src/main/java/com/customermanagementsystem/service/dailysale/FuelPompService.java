package com.customermanagementsystem.service.dailysale;

import com.customermanagementsystem.entity.dailysale.FuelPomp;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.dailysale.FuelPompMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToSave;
import com.customermanagementsystem.payload.request.dailysale.FuelPompRequestToUpdate;
import com.customermanagementsystem.repository.dailysale.FuelPompRepository;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuelPompService {

    private final FuelPompRepository fuelPompRepository;
    private final FuelPompMapper fuelPompMapper;
    private final ProductHelper productHelper;

    public String saveFuelPomp(FuelPompRequestToSave fuelPompRequest) {

        Product product = productHelper.isExistById(fuelPompRequest.getProductId());

        FuelPomp fuelPompToSave = fuelPompMapper.mapFuelPompRequestToSaveToFuelPomp(fuelPompRequest);
        fuelPompToSave.setProduct(product);

        fuelPompRepository.save(fuelPompToSave);

        return SuccessMessages.FUEL_POMP_SAVE;

    }

    public String updateFuelPomp(FuelPompRequestToUpdate fuelPompRequest, Long id) {

        return null;
    }
}
