package com.customermanagementsystem.service.fueltank;

import com.customermanagementsystem.entity.fueltank.FuelTank;
import com.customermanagementsystem.entity.fueltank.FuelTankSale;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.fueltank.FuelTankSaleMapper;
import com.customermanagementsystem.payload.request.fueltank.FuelTankSaleRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankSaleResponse;
import com.customermanagementsystem.repository.fueltank.FuelTankSaleRepository;
import com.customermanagementsystem.service.helper.ProductHelper;
import com.customermanagementsystem.service.helper.fueltank.FuelTankHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelTankSaleService {

    private final FuelTankSaleRepository fuelTankSaleRepository;
    private final FuelTankHelper fuelTankHelper;
    private final ProductHelper productHelper;
    private final FuelTankSaleMapper fuelTankSaleMapper;

    @Transactional
    public String saveFuelTankSale(FuelTankSaleRequest fuelTankSaleRequest) {

        FuelTank fuelTank = fuelTankHelper.isExistById(fuelTankSaleRequest.getFuelTankId());
        Product product = productHelper.isExistById(fuelTankSaleRequest.getProductId());

        FuelTankSale fuelTankSaleToSave = fuelTankSaleMapper.mapFuelTankFillReqToFuelTankFill(fuelTankSaleRequest);
        fuelTankSaleToSave.setFuelTank(fuelTank);
        fuelTankSaleToSave.setProduct(product);

        fuelTankHelper.fuelTankAmountCalculatorForSale(fuelTank,fuelTankSaleRequest.getAmount());

        fuelTankSaleRepository.save(fuelTankSaleToSave);
        return null;

    }

    public List<FuelTankSaleResponse> getAll() {
        return fuelTankSaleRepository.findAll()
                .stream()
                .map(fuelTankSaleMapper::mapFuelTankFillToFuelTankFillRes)
                .collect(Collectors.toList());
    }
}
