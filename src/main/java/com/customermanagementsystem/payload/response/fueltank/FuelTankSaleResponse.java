package com.customermanagementsystem.payload.response.fueltank;

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
public class FuelTankSaleResponse {

    private Long id;

    @JsonSerialize(using = LocalDateTimeToDateStringSerializer.class)
    private LocalDateTime dateTime;

    private String productName;

    private Double amount;

    private Double unitPrice;

    private Double total;
}
