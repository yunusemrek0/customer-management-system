package com.customermanagementsystem.payload.request.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LateChargeRequest {

    private Long customerId;

    private Double total;

    private String description;

}
