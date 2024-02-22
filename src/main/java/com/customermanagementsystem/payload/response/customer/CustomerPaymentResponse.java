package com.customermanagementsystem.payload.response.customer;

import com.customermanagementsystem.entity.enums.TypeOfCustomerPayment;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerPaymentResponse {

    private Long id;

    private String customerName;

    private LocalDateTime dateTime;

    private Double total;

    private TypeOfCustomerPayment typeOfCustomerPayment;

    private String description;


}
