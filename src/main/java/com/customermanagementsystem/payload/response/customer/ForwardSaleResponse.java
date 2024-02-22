package com.customermanagementsystem.payload.response.customer;

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
public class ForwardSaleResponse {


    private Long id;

    private LocalDateTime dateTime;

    private String productName;

    private Double unitPrice;

    private Double amount;

    private Double total;

    private String customerName;

}
