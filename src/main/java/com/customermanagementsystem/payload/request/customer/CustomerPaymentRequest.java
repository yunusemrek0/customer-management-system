package com.customermanagementsystem.payload.request.customer;

import com.customermanagementsystem.entity.enums.TypeOfCustomerPayment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPaymentRequest {


    @NotNull(message = "Toplam tutar boş bırakılamaz")
    @DecimalMin(value = "0.00",message = "Toplam tutar 0.00 'dan küçük veya eşit olamaz.")
    private Double total;


    @NotNull(message = "Lütfen ödemete tipi seçiniz.")
    private TypeOfCustomerPayment typeOfCustomerPayment;


    private String description;

    @NotNull(message = "Lütfen müşteri seçiniz.")
    private Long customerId;


}
