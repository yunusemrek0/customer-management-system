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
public class CustomerDetailResponse {

    private LocalDateTime dateTimeFS;

    private String productNameFS;

    private Double unitPriceFS;

    private Double amountFS;

    private Double totalFS;

    private Double totalCP;

    private LocalDateTime dateTimeCP;

    private Double totalLC;

    private LocalDateTime dateTimeLC;
}
