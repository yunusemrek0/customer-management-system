package com.customermanagementsystem.service.helper;

import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.exception.ResourceNotFoundException;
import com.customermanagementsystem.payload.messages.ErrorMessages;
import com.customermanagementsystem.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductHelper {

    private final ProductRepository productRepository;


    public Product isExistById(Long id){
        return productRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException(String.format(ErrorMessages.PRODUCT_NOT_FOUND_ID,id))
        );
    }

    public void productStockCalculatorForPurchase(Product product,Double totalAmount){

        double newTotalAmount = product.getStockAmountAsLiter()+totalAmount;
        product.setStockAmountAsLiter(newTotalAmount);
        productRepository.save(product);
    }

    public void productStockCalculatorForDailySale (Product product,Double totalAmount){

        double newTotalAmount = product.getStockAmountAsLiter()-totalAmount;
        product.setStockAmountAsLiter(newTotalAmount);
        productRepository.save(product);
    }
}
