package com.customermanagementsystem.service.helper.dailysale;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.enums.TypeOfCustomerPayment;
import com.customermanagementsystem.repository.customer.CustomerPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerPaymentHelperForDailySale {

    private final CustomerPaymentRepository customerPaymentRepository;


    public List<CustomerPayment> getByDailySaleNull(){
        return customerPaymentRepository.getByDailySaleIsNull();
    }

    public double totalCustomerPaymentForCreditCard(List<CustomerPayment> customerPayments){
        double total=0;
        for (CustomerPayment customerPayment:customerPayments){
            if (customerPayment.getTypeOfCustomerPayment().equals(
                    TypeOfCustomerPayment.CREDIT_CARD)){
                total+= customerPayment.getTotal();
            }
        }
        return total;
    }

    public double totalCustomerPaymentForCashOrBankTransfer(List<CustomerPayment> customerPayments){
        double total=0;
        for (CustomerPayment customerPayment:customerPayments){
            if (!customerPayment.getTypeOfCustomerPayment().equals(
                    TypeOfCustomerPayment.CREDIT_CARD)){
                total+= customerPayment.getTotal();
            }
        }
        return total;
    }
}
