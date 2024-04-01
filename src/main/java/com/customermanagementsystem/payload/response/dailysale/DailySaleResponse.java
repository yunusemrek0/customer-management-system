package com.customermanagementsystem.payload.response.dailysale;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.RoundingMode;
import java.text.DecimalFormat;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DailySaleResponse {

    private Long id;

    private LocalDateTime dateTime;

    private Double reportZ;

    private Double totalFuelPompSales;

    private Double totalCash;

    private Double bankTransferTotal;

    private Double totalForwardSalesForCashPrice;

    private Double totalForwardSalesForForwardPrice;

    private Double totalCustomerPaymentsWithCash;

    private Double totalCustomerPaymentsWithCreditCard;

    private Double totalEmployeeExpense;

    private Double totalPosDeviceSale;

    private Double balance;

    private Double totalIncome;

}
