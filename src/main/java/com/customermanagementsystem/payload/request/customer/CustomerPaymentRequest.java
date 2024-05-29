package com.customermanagementsystem.payload.request.customer;

import com.customermanagementsystem.entity.enums.TypeOfCustomerPayment;
import com.customermanagementsystem.payload.request.customer.abstraction.AbstractCustomerMovementRequest;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CustomerPaymentRequest extends AbstractCustomerMovementRequest {


    @NotNull(message = "Toplam tutar boş bırakılamaz")
    @DecimalMin(value = "0.00",message = "Toplam tutar 0.00 'dan küçük veya eşit olamaz.")
    private Double total;


    @NotNull(message = "Lütfen ödemete tipi seçiniz.")
    private TypeOfCustomerPayment typeOfCustomerPayment;


}
