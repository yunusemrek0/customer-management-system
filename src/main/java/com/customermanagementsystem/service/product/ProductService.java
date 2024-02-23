package com.customermanagementsystem.service.product;

import com.customermanagementsystem.entity.product.Dealer;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.product.ProductMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.product.ProductRequest;
import com.customermanagementsystem.payload.response.product.ProductResponse;
import com.customermanagementsystem.repository.product.ProductRepository;
import com.customermanagementsystem.service.helper.DealerHelper;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final DealerHelper dealerHelper;
    private final ProductMapper productMapper;
    private final ProductHelper productHelper;


    public String saveProduct(ProductRequest productRequest) {

        Dealer dealer = dealerHelper.isExistById(productRequest.getDealerId());

        Product productToSave = productMapper.mapProductRequestToProduct(productRequest);
        productToSave.setDealer(dealer);

        productRepository.save(productToSave);

        return SuccessMessages.PRODUCT_SAVE;

    }

    public String updateProduct(ProductRequest productRequest, Long id) {

        productHelper.isExistById(id);
        Dealer dealer = dealerHelper.isExistById(productRequest.getDealerId());

        Product productToUpdate = productMapper.mapProductRequestToProduct(productRequest);
        productToUpdate.setId(id);
        productToUpdate.setDealer(dealer);

        productRepository.save(productToUpdate);

        return SuccessMessages.PRODUCT_UPDATE;
    }

    public List<ProductResponse> getAll() {

        return productRepository.findAll()
                .stream()
                .map(productMapper::mapProductToProductResponse)
                .collect(Collectors.toList());
    }
}
