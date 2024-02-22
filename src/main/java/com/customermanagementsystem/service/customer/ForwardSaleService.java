package com.customermanagementsystem.service.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.customer.ForwardSale;
import com.customermanagementsystem.entity.product.Product;
import com.customermanagementsystem.payload.mapper.customer.ForwardSaleMapper;
import com.customermanagementsystem.payload.messages.SuccessMessagges;
import com.customermanagementsystem.payload.request.customer.ForwardSaleRequest;
import com.customermanagementsystem.repository.customer.ForwardSaleRepository;
import com.customermanagementsystem.service.helper.CustomerHelper;
import com.customermanagementsystem.service.helper.ProductHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ForwardSaleService {

    private final ForwardSaleRepository forwardSaleRepository;
    private final ProductHelper productHelper;
    private final CustomerHelper customerHelper;
    private final ForwardSaleMapper forwardSaleMapper;


    @Transactional
    public String saveForwardSale(ForwardSaleRequest forwardSaleRequest) {

        Product product = productHelper.isExistById(forwardSaleRequest.getProductId());
        Customer customer = customerHelper.isExistById(forwardSaleRequest.getCustomerId());


        ForwardSale forwardSaleToSave = forwardSaleMapper.mapForwardSaleRequestToForwardSale(forwardSaleRequest);
        forwardSaleToSave.setCustomer(customer);
        forwardSaleToSave.setProduct(product);

        forwardSaleRepository.save(forwardSaleToSave);

        customerHelper.customerBalanceCalculatorForSale(customer,forwardSaleToSave.getTotal());

        return SuccessMessagges.FORWARD_SALE_SAVE;
    }
}
