package com.customermanagementsystem.payload.request.dailysale;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailySaleBalanceRequest {

    private Double totalCash;

    private Double bankTransferTotal;

}
