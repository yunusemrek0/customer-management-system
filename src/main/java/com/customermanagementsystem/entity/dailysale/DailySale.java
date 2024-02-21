package com.customermanagementsystem.entity.dailysale;

import com.customermanagementsystem.entity.customer.CashProceed;
import com.customermanagementsystem.entity.customer.ForwardSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

public class DailySale {

    private Long id;

    private LocalDateTime dateTime;

    private Double reportZ;
/*
    private Double dailyForwardSaleForDiesel;

    private Double dailyForwardSaleAsLiterForDiesel;

    private Double dailyForwardSaleForGasoline;

    private Double dailyForwardSaleAsLiterForGasoline;

    private Double dailyForwardSaleForGas;

    private Double dailyForwardSaleAsLiterForGas;

    private Double dailySaleForDiesel;

    private Double dailySaleAsLiterForDiesel;

    private Double dailyForGasoline;

    private Double dailySaleAsLiterForGasoline;

    private Double dailySaleForGas;

    private Double dailySaleAsLiterForGas;

 */
    private Double totalCash;



    @OneToMany
    private List<ForwardSale> forwardSales;

    @OneToMany
    private List<CashProceed> cashProceeds;

    private Double totalCashProceed;

    @OneToMany
    private List<EmployeeExpense> employeeExpenses;

    private Double totalEmployeeExpense;
}
