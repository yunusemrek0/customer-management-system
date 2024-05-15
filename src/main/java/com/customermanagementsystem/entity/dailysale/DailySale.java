package com.customermanagementsystem.entity.dailysale;

import com.customermanagementsystem.entity.customer.CustomerPayment;
import com.customermanagementsystem.entity.customer.forwardsale.ForwardSale;
import com.customermanagementsystem.entity.dailysale.posdevice.PosDeviceSale;
import com.customermanagementsystem.entity.employee.EmployeeExpense;
import com.customermanagementsystem.entity.employee.EmployeePayment;
import com.customermanagementsystem.entity.fueltank.FuelTankFill;
import com.customermanagementsystem.entity.fueltank.FuelTankSale;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "daily_sale")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailySale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTime;

    private Double reportZ;

    @OneToMany(mappedBy = "dailySale")
    private List<DailyFuelOilSale> dailyFuelOilSales;

    private Double totalFuelOilSales;

    private Double totalFuelOilSalesAsPurchasePrice;

    private Double totalCash;

    private Double bankTransferTotal;


    @OneToMany(mappedBy = "dailySale")
    private List<ForwardSale> forwardSales;

    private Double totalForwardSalesForCashPrice;

    private Double totalForwardSalesForForwardPrice;


    @OneToMany(mappedBy = "dailySale")
    private List<CustomerPayment> customerPayments;

    private Double totalCustomerPaymentsWithCash;

    private Double totalCustomerPaymentsWithCreditCard;

    @OneToMany(mappedBy = "dailySale")
    private List<EmployeeExpense> employeeExpenses;

    private Double totalEmployeeExpense;

    @OneToMany(mappedBy = "dailySale")
    private List<EmployeePayment> employeePayments;

    private Double totalEmployeePayment;

    @OneToMany(mappedBy = "dailySale")
    private List<PosDeviceSale> posDeviceSales;

    private Double totalPosDeviceSale;

    @OneToMany(mappedBy = "dailySale")
    private List<DailyExpense> dailyExpenses;

    private Double totalExpenses;

    @OneToMany(mappedBy = "dailySale")
    private List<FuelTankFill> fuelTankFills;

    private Double totalFuelTankFill;

    @OneToMany(mappedBy = "dailySale")
    private List<FuelTankSale> fuelTankSales;

    private Double totalFuelTankSale;

    private Double balance;

    private Double totalIncome;
}
