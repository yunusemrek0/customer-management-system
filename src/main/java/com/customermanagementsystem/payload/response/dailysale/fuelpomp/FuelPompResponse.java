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
public class FuelPompResponse {

    private Long id;

    private String name;

    private Double oldNumerator;

    private Double newNumerator;

    private LocalDateTime updateDateTime;

    private String productName;

    private Boolean isTransferred;


}
