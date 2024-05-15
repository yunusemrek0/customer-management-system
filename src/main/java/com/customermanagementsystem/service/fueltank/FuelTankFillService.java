package com.customermanagementsystem.service.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTank;
import com.customermanagementsystem.entity.fueltank.FuelTankFill;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.fueltank.FuelTankFillMapper;
import com.customermanagementsystem.payload.request.fueltank.FuelTankFillRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankFillResponse;
import com.customermanagementsystem.repository.fueltank.FuelTankFillRepository;
import com.customermanagementsystem.service.helper.fueltank.FuelTankHelper;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelTankFillService {

    private final FuelTankFillRepository fuelTankFillRepository;
    private final FuelTankHelper fuelTankHelper;
    private final ProductHelper productHelper;
    private final FuelTankFillMapper fuelTankFillMapper;


    @Transactional
    public String saveFuelTankFill(FuelTankFillRequest fuelTankFillRequest) {

        FuelTank fuelTank = fuelTankHelper.isExistById(fuelTankFillRequest.getFuelTankId());
        Product product = productHelper.isExistById(fuelTankFillRequest.getProductId());

        FuelTankFill fuelTankFillToSave = fuelTankFillMapper.mapFuelTankFillReqToFuelTankFill(fuelTankFillRequest);
        fuelTankFillToSave.setFuelTank(fuelTank);
        fuelTankFillToSave.setProduct(product);

        fuelTankHelper.fuelTankAmountCalculatorForFilling(fuelTank,fuelTankFillRequest.getAmount());

        fuelTankFillRepository.save(fuelTankFillToSave);
        return null;


    }

    public List<FuelTankFillResponse> getAll() {
        return fuelTankFillRepository.findAll()
                .stream()
                .map(fuelTankFillMapper::mapFuelTankFillToFuelTankFillRes)
                .collect(Collectors.toList());
    }
}
