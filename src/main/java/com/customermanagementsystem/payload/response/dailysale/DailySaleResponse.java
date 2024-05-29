package com.customermanagementsystem.payload.response.dailysale;

import com.customermanagementsystem.service.helper.LocalDateTimeToDateStringSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    @JsonSerialize(using = LocalDateTimeToDateStringSerializer.class)
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
