package com.customermanagementsystem.payload.mapper.dailysale;

import com.customermanagementsystem.entity.dailysale.DailySale;
import com.customermanagementsystem.payload.request.dailysale.DailySaleRequest;
import com.customermanagementsystem.payload.response.dailysale.DailySaleResponse;
import com.customermanagementsystem.service.helper.DateTimeTranslator;
import com.customermanagementsystem.service.helper.MapperHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Component
@RequiredArgsConstructor
public class DailySaleMapper {

    private final DateTimeTranslator dateTimeTranslator;

    private final MapperHelper mapperHelper;


    public DailySale mapDailySaleRequestToDailySale(DailySaleRequest dailySaleRequest) {
        return DailySale.builder()
                .reportZ(mapperHelper.formatDoubleValue(dailySaleRequest.getReportZ()))
                .dateTime(dateTimeTranslator.parseLocalDateTime())
                .build();
    }



    public DailySaleResponse mapDailySaleToDailySaleResponse(DailySale dailySale) {
        return DailySaleResponse.builder()
                .id(dailySale.getId())
                .dateTime(dailySale.getDateTime())
                .reportZ(mapperHelper.formatDoubleValue(dailySale.getReportZ()))
                .totalFuelPompSales(mapperHelper.formatDoubleValue(dailySale.getTotalFuelOilSales()))
                .totalCash(mapperHelper.formatDoubleValue(dailySale.getTotalCash()))
                .bankTransferTotal(mapperHelper.formatDoubleValue(dailySale.getBankTransferTotal()))
                .totalForwardSalesForCashPrice(mapperHelper.formatDoubleValue(dailySale.getTotalForwardSalesForCashPrice()))
                .totalForwardSalesForForwardPrice(mapperHelper.formatDoubleValue(dailySale.getTotalForwardSalesForForwardPrice()))
                .totalCustomerPaymentsWithCash(mapperHelper.formatDoubleValue(dailySale.getTotalCustomerPaymentsWithCash()))
                .totalCustomerPaymentsWithCreditCard(mapperHelper.formatDoubleValue(dailySale.getTotalCustomerPaymentsWithCreditCard()))
                .totalEmployeeExpense(mapperHelper.formatDoubleValue(dailySale.getTotalEmployeeExpense()))
                .totalPosDeviceSale(mapperHelper.formatDoubleValue(dailySale.getTotalPosDeviceSale()))
                .balance(mapperHelper.formatDoubleValue(dailySale.getBalance()))
                .totalIncome(mapperHelper.formatDoubleValue(dailySale.getTotalIncome()))
                .build();
    }













}
