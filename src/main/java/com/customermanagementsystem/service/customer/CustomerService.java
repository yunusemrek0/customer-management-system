package com.customermanagementsystem.service.customer;

import com.customermanagementsystem.entity.customer.Customer;
import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.customer.forwardsale.LateCharge;
import com.customermanagementsystem.payload.mapper.customer.CustomerMapper;
import com.customermanagementsystem.payload.messages.SuccessMessages;
import com.customermanagementsystem.payload.request.customer.CustomerRequest;
import com.customermanagementsystem.payload.response.customer.CustomerDetailResponse;
import com.customermanagementsystem.payload.response.customer.CustomerResponse;
import com.customermanagementsystem.repository.customer.CustomerPaymentRepository;
import com.customermanagementsystem.repository.customer.CustomerRepository;
import com.customermanagementsystem.repository.customer.ForwardSaleRepository;
import com.customermanagementsystem.repository.customer.LateChargeRepository;
import com.customermanagementsystem.service.helper.CustomerHelper;
import com.customermanagementsystem.service.helper.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final PageableHelper pageableHelper;
    private final CustomerHelper customerHelper;
    private final ForwardSaleRepository forwardSaleRepository;
    private final CustomerPaymentRepository customerPaymentRepository;
    private final LateChargeRepository lateChargeRepository;


    public String saveCustomer(CustomerRequest customerRequest) {

        Customer customerToSave = customerMapper.mapCustomerRequestToCustomer(customerRequest);
        customerRepository.save(customerToSave);

        return SuccessMessages.CUSTOMER_SAVE;
    }

    public Page<CustomerResponse> getByPage(int page, int size, String sort, String type) {

        Pageable pageable = pageableHelper.getPageableWithProperties(page,size,sort,type);

        return customerRepository
                .findAll(pageable)
                .map(customerMapper::mapCustomerToCustomerResponse);
    }

    public List<CustomerResponse> getByName(String customerName) {

        return customerRepository.findByNameIgnoreCaseContaining(customerName)
                .stream()
                .map(customerMapper::mapCustomerToCustomerResponse)
                .collect(Collectors.toList());
    }

    public String updateCustomer(CustomerRequest customerRequest, Long id) {

        Customer customer = customerHelper.isExistById(id);

        Customer customerToUpdate = customerMapper.mapCustomerRequestToCustomer(customerRequest);
        customerToUpdate.setId(id);
        customerToUpdate.setBalance(customer.getBalance());
        customerRepository.save(customerToUpdate);

        return SuccessMessages.CUSTOMER_UPDATE;


    }

    public List<CustomerResponse> getAll() {

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::mapCustomerToCustomerResponse)
                .collect(Collectors.toList());
    }

    public CustomerResponse getById(Long id) {

        return customerMapper.mapCustomerToCustomerResponse(customerHelper.isExistById(id));
    }

    public List<CustomerDetailResponse> getDetails(Long id) {

        List<ForwardSale> forwardSales = forwardSaleRepository.getByCustomerId(id);
        List<CustomerPayment> customerPayments = customerPaymentRepository.getByCustomerId(id);
        List<LateCharge> lateCharges = lateChargeRepository.getByCustomerId(id);

        forwardSales.sort(Comparator.comparing(ForwardSale::getDateTime));
        customerPayments.sort(Comparator.comparing(CustomerPayment::getDateTime));
        lateCharges.sort(Comparator.comparing(LateCharge::getDateTime));


        return customerMapper.mapAllDetailsToCustomerDetailResponse(forwardSales,customerPayments,lateCharges);
    }

    public Double getTotalSumOfBalance() {
        return customerRepository.findSumOfBalance();
    }
}
