package com.customermanagementsystem.payload.response.fueltank;

import com.customermanagementsystem.payload.response.customer.abstraction.AbstractCustomerMovementResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FuelTankForwardSaleResponse extends AbstractCustomerMovementResponse {

}
