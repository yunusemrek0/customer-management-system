package com.customermanagementsystem.payload.response.customer;

import com.customermanagementsystem.payload.response.customer.abstraction.AbstractCustomerMovementResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ForwardSaleResponse extends AbstractCustomerMovementResponse {



}
