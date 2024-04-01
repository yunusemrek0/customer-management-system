package com.customermanagementsystem.payload.mapper.product;

import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.request.product.ProductRequest;
import com.customermanagementsystem.payload.response.product.ProductResponse;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final MapperHelper mapperHelper;

    public Product mapProductRequestToProduct(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .priceForCash(mapperHelper.formatDoubleValue(productRequest.getPriceForCash()))
                .priceForForwardSale(mapperHelper.formatDoubleValue(productRequest.getPriceForForwardSale()))
                .priceForWithTransportation(mapperHelper.formatDoubleValue(productRequest.getPriceForWithTransportation()))
                .purchasePrice(mapperHelper.formatDoubleValue(productRequest.getPurchasePrice()))
                .stockAmountAsLiter(mapperHelper.formatDoubleValue(productRequest.getStockAmountAsLiter()))
                .build();
    }


    public ProductResponse mapProductToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .priceForCash(mapperHelper.formatDoubleValue(product.getPriceForCash()))
                .priceForForwardSale(mapperHelper.formatDoubleValue(product.getPriceForForwardSale()))
                .priceForWithTransportation(mapperHelper.formatDoubleValue(product.getPriceForWithTransportation()))
                .purchasePrice(mapperHelper.formatDoubleValue(product.getPurchasePrice()))
                .stockAmountAsLiter(mapperHelper.formatDoubleValue(product.getStockAmountAsLiter()))
                .build();
    }
}
