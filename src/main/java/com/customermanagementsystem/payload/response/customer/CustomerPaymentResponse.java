package com.customermanagementsystem.payload.response.customer;

import com.customermanagementsystem.entity.enums.TypeOfCustomerPayment;
import com.customermanagementsystem.payload.response.customer.abstraction.AbstractCustomerMovementResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerPaymentResponse extends AbstractCustomerMovementResponse {

    private TypeOfCustomerPayment typeOfCustomerPayment;//***
}
