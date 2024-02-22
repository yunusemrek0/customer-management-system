package com.customermanagementsystem.payload.mapper.product;

import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.request.product.ProductRequest;
import com.customermanagementsystem.payload.response.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    public Product mapProductRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .priceForCash(productRequest.getPriceForCash())
                .priceForForwardSale(productRequest.getPriceForForwardSale())
                .priceForWithTransportation(productRequest.getPriceForWithTransportation())
                .purchasePrice(productRequest.getPurchasePrice())
                .stockAmountAsLiter(productRequest.getStockAmountAsLiter())
                .build();
    }


    public ProductResponse mapProductToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .priceForCash(product.getPriceForCash())
                .priceForForwardSale(product.getPriceForForwardSale())
                .priceForWithTransportation(product.getPriceForWithTransportation())
                .purchasePrice(product.getPurchasePrice())
                .stockAmountAsLiter(product.getStockAmountAsLiter())
                .dealerName(product.getDealer().getName())
                .build();
    }
}
