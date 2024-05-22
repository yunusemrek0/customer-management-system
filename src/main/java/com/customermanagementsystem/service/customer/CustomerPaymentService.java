package com.customermanagementsystem.service.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.payload.mapper.customer.CustomerPaymentMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.customer.CustomerPaymentRequest;
import com.customermanagementsystem.payload.response.customer.CustomerPaymentResponse;
import com.customermanagementsystem.repository.customer.CustomerPaymentRepository;
import com.customermanagementsystem.service.helper.CustomerHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerPaymentService {


    private final CustomerPaymentRepository customerPaymentRepository;
    private final CustomerHelper customerHelper;
    private final CustomerPaymentMapper customerPaymentMapper;

    @Transactional
    public String saveCustomerPayment(CustomerPaymentRequest customerPaymentRequest) {

        Customer customer = customerHelper.isExistById(customerPaymentRequest.getCustomerId());
        customerHelper.customerBalanceCalculatorForPayment(customer,customerPaymentRequest.getTotal());

        CustomerPayment customerPaymentToSave = customerPaymentMapper.mapCustomerPaymentRequestToCustomerPayment(customerPaymentRequest);
        customerPaymentToSave.setCustomer(customer);

        customerPaymentRepository.save(customerPaymentToSave);

        return SuccessMessages.CUSTOMER_PAYMENT_SAVE;

    }

    public List<CustomerPaymentResponse> getByCustomer(Long customerId) {
        customerHelper.isExistById(customerId);

        return customerPaymentRepository.getByCustomerId(customerId)
                .stream()
                .map(customerPaymentMapper :: mapCustomerPaymentToCustomerPaymentResponse)
                .collect(Collectors.toList());
    }

    public List<CustomerPaymentResponse> getAll() {

        return customerPaymentRepository.getByDailySaleIsNull()
                .stream()
                .map(customerPaymentMapper::mapCustomerPaymentToCustomerPaymentResponse)
                .collect(Collectors.toList());
    }

    public String deleteById(Long id) {

        CustomerPayment customerPaymentToDelete = customerPaymentRepository.findById(id).get();

        Customer customer = customerHelper.isExistById(customerPaymentToDelete.getCustomer().getId());

        customerHelper.customerBalanceCalculatorForSale(customer,customerPaymentToDelete.getTotal());

        customerPaymentRepository.deleteById(id);

        return null;

    }
}
