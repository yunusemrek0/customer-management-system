package com.customermanagementsystem.payload.mapper.product;

import com.customermanagementsystem.entity.product.ProductPurchase;
import com.customermanagementsystem.payload.request.product.ProductPurchaseRequest;
import com.customermanagementsystem.payload.response.product.ProductPurchaseResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPurchaseMapper {

    private final DateTimeTranslator dateTimeTranslator;
    public ProductPurchase mapProductPurchaseRequestToProductPurchase(ProductPurchaseRequest productPurchaseRequest){

        return ProductPurchase.builder()
                .purchasePrice(productPurchaseRequest.getPurchasePrice())
                .amount(productPurchaseRequest.getAmount())
                .total(productPurchaseRequest.getPurchasePrice()*productPurchaseRequest.getAmount())
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }


    public ProductPurchaseResponse mapProductPurchaseToProductPurchaseResponse(ProductPurchase productPurchase){

        return ProductPurchaseResponse.builder()
                .id(productPurchase.getId())
                .productName(productPurchase.getProduct().getName())
                .dealerName(productPurchase.getDealer().getName())
                .purchasePrice(productPurchase.getPurchasePrice())
                .amount(productPurchase.getAmount())
                .total(productPurchase.getTotal())
                .dateTime(productPurchase.getDateTime())
                .build();
    }


}
