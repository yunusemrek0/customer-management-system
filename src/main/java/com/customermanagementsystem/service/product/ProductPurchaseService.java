package com.customermanagementsystem.service.product;

import com.customermanagementsystem.entity.product.Dealer;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.entity.product.ProductPurchase;
import com.customermanagementsystem.payload.mapper.product.ProductPurchaseMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.product.ProductPurchaseRequest;
import com.customermanagementsystem.payload.request.statistic.DateTimeRequest;
import com.customermanagementsystem.payload.response.dailysale.posdevice.PosDeviceSaleResponse;
import com.customermanagementsystem.payload.response.product.ProductPurchaseResponse;
import com.customermanagementsystem.repository.product.ProductPurchaseRepository;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.DealerHelper;
import com.customermanagementsystem.service.helper.MapperHelper;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductPurchaseService {

    private final ProductPurchaseRepository productPurchaseRepository;
    private final ProductHelper productHelper;
    private final DealerHelper dealerHelper;
    private final ProductPurchaseMapper productPurchaseMapper;
    private final DateTimeTranslator dateTimeTranslator;
    private final MapperHelper mapperHelper;

    @Transactional
    public String saveProductPurchase(ProductPurchaseRequest productPurchaseRequest) {

        Product product = productHelper.isExistById(productPurchaseRequest.getProductId());
        Dealer dealer = dealerHelper.isExistById(productPurchaseRequest.getDealerId());

        ProductPurchase productPurchaseToSave = productPurchaseMapper.mapProductPurchaseRequestToProductPurchase(productPurchaseRequest);
        productPurchaseToSave.setProduct(product);
        productPurchaseToSave.setDealer(dealer);

        productHelper.productStockCalculatorForPurchase(product,productPurchaseToSave.getAmount());
        dealerHelper.dealerBalanceCalculatorForPurchase(dealer,productPurchaseToSave.getTotal());

        productPurchaseRepository.save(productPurchaseToSave);

        return SuccessMessages.PRODUCT_PURCHASE_SAVE;

    }

    public List<ProductPurchaseResponse> getByDealer(Long dealerId) {

        dealerHelper.isExistById(dealerId);

        return productPurchaseRepository.getByDealerId(dealerId)
                .stream()
                .map(productPurchaseMapper::mapProductPurchaseToProductPurchaseResponse)
                .collect(Collectors.toList());

    }

    public List<ProductPurchaseResponse> getByProduct(Long productId) {
        productHelper.isExistById(productId);

        return productPurchaseRepository.getByProductId(productId)
                .stream()
                .map(productPurchaseMapper::mapProductPurchaseToProductPurchaseResponse)
                .collect(Collectors.toList());
    }

    public List<ProductPurchaseResponse> getAll() {

        return productPurchaseRepository.findAll()
                .stream()
                .map(productPurchaseMapper::mapProductPurchaseToProductPurchaseResponse)
                .collect(Collectors.toList());
    }

    public List<ProductPurchaseResponse> productPurchaseBetweenDate(DateTimeRequest dateTimeRequest) {
        List<Object[]> results = productPurchaseRepository.findPurchaseSummary( dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getStartDate()),
                dateTimeTranslator.parseLocalDateTime(dateTimeRequest.getEndDate()));

        List<ProductPurchaseResponse> responseList = new ArrayList<>();

        for (Object[] result : results) {
            ProductPurchaseResponse response = new ProductPurchaseResponse();
            response.setId((Long) result[0]); // Ürün id'sini burada kullanıyoruz.
            response.setProductName((String) result[1]);
            response.setAmount(mapperHelper.formatDoubleValue((Double) result[2]));
            response.setTotal(mapperHelper.formatDoubleValue((Double) result[3]));

            responseList.add(response);
        }

        return responseList;
    }
}
