package com.customermanagementsystem.payload.mapper.product;

import com.customermanagementsystem.entity.product.ProductPurchase;
import com.customermanagementsystem.payload.request.product.ProductPurchaseRequest;
import com.customermanagementsystem.payload.response.product.ProductPurchaseResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPurchaseMapper {

    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;
    public ProductPurchase mapProductPurchaseRequestToProductPurchase(ProductPurchaseRequest productPurchaseRequest){

        return ProductPurchase.builder()
                .purchasePrice(mapperHelper.formatDoubleValue(productPurchaseRequest.getPurchasePrice()))
                .amount(mapperHelper.formatDoubleValue(productPurchaseRequest.getAmount()))
                .total(mapperHelper.formatDoubleValue(productPurchaseRequest.getPurchasePrice()*productPurchaseRequest.getAmount()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }


    public ProductPurchaseResponse mapProductPurchaseToProductPurchaseResponse(ProductPurchase productPurchase){

        return ProductPurchaseResponse.builder()
                .id(productPurchase.getId())
                .productName(productPurchase.getProduct().getName())
                .dealerName(productPurchase.getDealer().getName())
                .purchasePrice(mapperHelper.formatDoubleValue(productPurchase.getPurchasePrice()))
                .amount(mapperHelper.formatDoubleValue(productPurchase.getAmount()))
                .total(mapperHelper.formatDoubleValue(productPurchase.getTotal()))
                .dateTime(productPurchase.getDateTime())
                .build();
    }


}
