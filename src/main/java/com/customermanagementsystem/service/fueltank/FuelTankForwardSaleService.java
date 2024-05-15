package com.customermanagementsystem.service.fueltank;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.fueltank.FuelTank;
import com.customermanagementsystem.entity.fueltank.FuelTankForwardSale;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.fueltank.FuelTankForwardSaleMapper;
import com.customermanagementsystem.payload.request.fueltank.FuelTankForwardSaleRequest;
import com.customermanagementsystem.payload.response.fueltank.FuelTankForwardSaleResponse;
import com.customermanagementsystem.repository.fueltank.FuelTankForwardSaleRepository;
import com.customermanagementsystem.service.helper.CustomerHelper;
import com.customermanagementsystem.service.helper.ProductHelper;
import com.customermanagementsystem.service.helper.fueltank.FuelTankHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelTankForwardSaleService {

    private final FuelTankForwardSaleRepository fuelTankForwardSaleRepository;
    private final FuelTankHelper fuelTankHelper;
    private final ProductHelper productHelper;
    private final CustomerHelper customerHelper;
    private final FuelTankForwardSaleMapper fuelTankForwardSaleMapper;
    public String saveFuelTankForwardSale(FuelTankForwardSaleRequest fuelTankForwardSaleRequest) {

        FuelTank fuelTank = fuelTankHelper.isExistById(fuelTankForwardSaleRequest.getFuelTankId());
        Product product = productHelper.isExistById(fuelTankForwardSaleRequest.getProductId());
        Customer customer = customerHelper.isExistById(fuelTankForwardSaleRequest.getCustomerId());

        FuelTankForwardSale fuelTankForwardSaleToSave = fuelTankForwardSaleMapper.mapFuelTankForwardSaleReqToForwardSale(fuelTankForwardSaleRequest);
        fuelTankForwardSaleToSave.setFuelTank(fuelTank);
        fuelTankForwardSaleToSave.setCustomer(customer);
        fuelTankForwardSaleToSave.setProduct(product);

        fuelTankHelper.fuelTankAmountCalculatorForSale(fuelTank,fuelTankForwardSaleRequest.getAmount());
        customerHelper.customerBalanceCalculatorForSale(customer,fuelTankForwardSaleToSave.getTotal());

        fuelTankForwardSaleRepository.save(fuelTankForwardSaleToSave);

        return null;

    }

    public List<FuelTankForwardSaleResponse> getAll() {

        return fuelTankForwardSaleRepository.findAll()
                .stream()
                .map(fuelTankForwardSaleMapper::mapFuelTankForwardSaleToResponse)
                .collect(Collectors.toList());
    }
}
