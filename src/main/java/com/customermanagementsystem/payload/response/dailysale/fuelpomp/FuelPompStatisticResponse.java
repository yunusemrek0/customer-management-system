package com.customermanagementsystem.payload.response.dailysale.fuelpomp;

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
public class FuelPompStatisticResponse {

    private Long id;

    private LocalDateTime dateTime;

    private String fuelPompName;

    private Double amountAsLiter;

    private Double total;
}
