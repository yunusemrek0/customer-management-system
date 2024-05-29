package com.customermanagementsystem.payload.response.product;

import com.customermanagementsystem.service.helper.LocalDateTimeToDateStringSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
public class ProductPurchaseResponse {

    private Long id;

    @JsonSerialize(using = LocalDateTimeToDateStringSerializer.class)
    private LocalDateTime dateTime;

    private String dealerName;

    private String productName;

    private Double purchasePrice;

    private Double amount;

    private Double total;
}
