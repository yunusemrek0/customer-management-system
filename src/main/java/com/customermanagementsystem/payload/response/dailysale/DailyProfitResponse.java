package com.customermanagementsystem.payload.response.dailysale;


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
public class DailyProfitResponse {

    private LocalDateTime dateTime;

    private Double profit;

    private Double totalIncome;
}
