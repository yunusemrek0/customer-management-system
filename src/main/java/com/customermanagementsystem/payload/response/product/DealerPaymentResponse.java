package com.customermanagementsystem.payload.response.product;

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
public class DealerPaymentResponse {


    private Long id;

    private LocalDateTime dateTime;

    private String dealerName;

    private Double total;
}
